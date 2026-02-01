package net.javaguides.springboot.service;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

@Service
public class ItemService {

    private final LongCounter employeeCreatedCounter;
    private final AtomicInteger activeUsers;
    private final Tracer tracer;

    public ItemService(OpenTelemetry openTelemetry) {
        Meter meter = openTelemetry.getMeter(ItemService.class.getName());
        tracer = openTelemetry.getTracer(ItemService.class.getName());

        employeeCreatedCounter = meter
            .counterBuilder("employee.created")
            .setDescription("Number of employees created")
            .build();

        activeUsers = new AtomicInteger(new Random().nextInt());
        meter.gaugeBuilder("number.of.active.users")
            .setDescription("Number of active users")
            .buildWithCallback(observableMeasurement -> observableMeasurement.record(activeUsers.get()));
    }

    public void incrementEmployeeCreated() {
        employeeCreatedCounter.add(1, Attributes.empty());
    }

    public Number fetchActiveUsers() {
        return activeUsers.get();
    }

    public String performSomeOperation() {
        Span span = tracer.spanBuilder("performSomeOperation").startSpan();
        try (var scope = span.makeCurrent()) {
            // Perform operation
            span.setStatus(StatusCode.OK);
            return "Operation performed";
        } catch (Exception e) {
            span.recordException(e).setStatus(StatusCode.ERROR, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }
}
