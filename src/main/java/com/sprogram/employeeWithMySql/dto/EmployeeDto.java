package com.sprogram.employeeWithMySql.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public record EmployeeDto(

        @NotBlank(message = "first Name is required")
        String firstName,

        @NotBlank(message = "Last Name is required")
        String lastName,

        @DateTimeFormat(pattern = "dd/MM/yyyy")
        @Past(message = "Enter valid date")
        LocalDate dateOfBirth,

        @NotNull
        @Min(10)
        @Max(100)
        Integer age,


        @Pattern(regexp = "^\\(?\\+49\\)?[\\s-]?\\d{3}[\\s-]?\\d{8}$", message = "German mobileNumber is required")
        String mobileNumber,

        @Email
        String emailAddress
) {

}
