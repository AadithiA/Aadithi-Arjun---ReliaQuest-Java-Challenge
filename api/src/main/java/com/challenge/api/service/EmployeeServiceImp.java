package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeMock;
import com.challenge.api.model.EmployeeRequestCreation;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * In-memory implementation of {@link EmployeeServices}. Employees are stored in a {@link ConcurrentHashMap} keyed
 * by UUID and seeded with a handful of mock records on startup.
 */
@Service
public class EmployeeServiceImp implements EmployeeServices {

    private final Map<UUID, Employee> employees = new ConcurrentHashMap<>();

    public EmployeeServiceImp() {
        seedMockData();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.copyOf(employees.values());
    }

    @Override
    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.get(uuid);
    }

    @Override
    public Employee createEmployee(EmployeeRequestCreation request) {
        if (request.getFirstName() == null || request.getLastName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "firstName and lastName are required");
        }

        EmployeeMock employee = new EmployeeMock();
        employee.setUuid(UUID.randomUUID());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setFullName(request.getFirstName() + " " + request.getLastName());
        employee.setSalary(request.getSalary());
        employee.setAge(request.getAge());
        employee.setJobTitle(request.getJobTitle());
        employee.setEmail(request.getEmail());
        employee.setContractHireDate(Instant.now());

        employees.put(employee.getUuid(), employee);
        return employee;
    }

    private void seedMockData() {
        createMockEmployee("Alice", "Nguyen", 95000, 29, "Software Engineer", "alice.nguyen@example.com");
        createMockEmployee("Ben", "Carter", 110000, 34, "Senior Software Engineer", "ben.carter@example.com");
        createMockEmployee("Chloe", "Martinez", 82000, 26, "QA Engineer", "chloe.martinez@example.com");
    }

    private void createMockEmployee(
            String firstName, String lastName, Integer salary, Integer age, String jobTitle, String email) {
        EmployeeRequestCreation request = new EmployeeRequestCreation();
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setSalary(salary);
        request.setAge(age);
        request.setJobTitle(jobTitle);
        request.setEmail(email);
        createEmployee(request);
    }
}
