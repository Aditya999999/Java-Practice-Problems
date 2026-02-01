package net.javaguides.springboot.controller;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final Tracer tracer;

    @Autowired
    public EmployeeController(OpenTelemetry openTelemetry) {
        this.tracer = openTelemetry.getTracer(EmployeeController.class.getName());
    }

    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        Span span = tracer.spanBuilder("getAllEmployees").startSpan();
        try (var scope = span.makeCurrent()) {
            List<Employee> employees = employeeRepository.findAll();
            span.setStatus(StatusCode.OK);
            return employees;
        } catch (Exception e) {
            span.recordException(e).setStatus(StatusCode.ERROR, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }

    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        Span span = tracer.spanBuilder("createEmployee").startSpan();
        try (var scope = span.makeCurrent()) {
            Employee savedEmployee = employeeRepository.save(employee);
            span.setStatus(StatusCode.OK);
            return savedEmployee;
        } catch (Exception e) {
            span.recordException(e).setStatus(StatusCode.ERROR, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }

    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Span span = tracer.spanBuilder("getEmployeeById").startSpan();
        try (var scope = span.makeCurrent()) {
            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
            span.setStatus(StatusCode.OK);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            span.recordException(e).setStatus(StatusCode.ERROR, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }

    // update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Span span = tracer.spanBuilder("updateEmployee").startSpan();
        try (var scope = span.makeCurrent()) {
            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmailId(employeeDetails.getEmailId());

            Employee updatedEmployee = employeeRepository.save(employee);
            span.setStatus(StatusCode.OK);
            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {
            span.recordException(e).setStatus(StatusCode.ERROR, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }

    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Span span = tracer.spanBuilder("deleteEmployee").startSpan();
        try (var scope = span.makeCurrent()) {
            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

            employeeRepository.delete(employee);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            span.setStatus(StatusCode.OK);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            span.recordException(e).setStatus(StatusCode.ERROR, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }
}
