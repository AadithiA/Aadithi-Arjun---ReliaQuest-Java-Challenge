package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeRequestCreation;
import java.util.List;
import java.util.UUID;

/**
 * Business logic for retrieving and creating Employees. Backed by an in-memory store; no real persistence layer
 * is required for this challenge.
 */
public interface EmployeeServices {

    /**
     * @return all known Employees, unfiltered.
     */
    List<Employee> getAllEmployees();

    /**
     * @param uuid Employee UUID to look up.
     * @return the matching Employee, or {@code null} if none exists.
     */
    Employee getEmployeeByUuid(UUID uuid);

    /**
     * @param request attributes necessary to create a new Employee.
     * @return the newly created Employee, with a generated UUID and hire date.
     */
    Employee createEmployee(EmployeeRequestCreation request);
}
