package net.javaguides.springboot;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.exporter.otlp.http.metrics.OtlpHttpMetricExporter;
import io.opentelemetry.micrometer1shim.OpenTelemetryMeterRegistry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;
import java.time.Duration;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    // Enable @Timed annotation
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Bean
    public OpenTelemetry openTelemetry() {
        return OpenTelemetrySdk.builder()
            .setMeterProvider(
                SdkMeterProvider.builder()
                    .setResource(
                        Resource.getDefault().toBuilder()
                            .put("service.name", "employee-management-system")
                            .put("instrumentation.provider", "micrometer")
                            .build())
                    .registerMetricReader(
                        PeriodicMetricReader.builder(
                                OtlpHttpMetricExporter.builder()
                                    .setEndpoint("https://otlp.nr-data.net/v1/metrics")
                                    .addHeader(
                                        "api-key", 
                                        Optional.ofNullable("d9fa7f7b923f8a4d8ef9923dd67067da6d1dNRAL")
                                            .filter(str -> !str.isEmpty() && !str.isBlank())
                                            .orElseThrow())
                                    .setAggregationTemporalitySelector(
                                        AggregationTemporalitySelector.deltaPreferred())
                                    .setDefaultAggregationSelector(
                                        DefaultAggregationSelector.getDefault()
                                            .with(
                                                InstrumentType.HISTOGRAM,
                                                Aggregation.explicitBucketHistogram()))
                                    .build())
                            .setInterval(Duration.ofSeconds(60))
                            .build())
                    .build())
            .build();
    }

    @Bean
    public MeterRegistry meterRegistry(OpenTelemetry openTelemetry) {
        return OpenTelemetryMeterRegistry.builder(openTelemetry).build();
    }
}
