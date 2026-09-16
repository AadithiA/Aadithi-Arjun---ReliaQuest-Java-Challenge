package com.challenge.api.model;

import lombok.Data;

/**
 * Client-supplied attributes required to create a new {@link Employee}. Fields such as {@code uuid},
 * {@code fullName}, and {@code contractHireDate} are server-generated and intentionally excluded here.
 */
@Data
public class EmployeeRequestCreation {

    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
}
