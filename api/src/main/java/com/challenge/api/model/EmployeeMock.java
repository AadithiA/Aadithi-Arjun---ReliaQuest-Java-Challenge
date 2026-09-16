package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * In-memory, mutable implementation of {@link Employee}. There is no real persistence layer backing this class;
 * instances are created and held in memory by the Service layer.
 */
@Data
@NoArgsConstructor
public class EmployeeMock implements Employee {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private String fullName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant contractHireDate;
    private Instant contractTerminationDate;
}
