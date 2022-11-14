package com.sprogram.employeeWithMySql.converter;

import com.sprogram.employeeWithMySql.dto.EmployeeDto;
import com.sprogram.employeeWithMySql.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeDto fromEntityToDto(Employee entity) {
        return new EmployeeDto
                (entity.getFirstName(), entity.getLastName(), entity.getDateOfBirth(), entity.getAge(), entity.getMobileNumber(), entity.getEmailAddress());
    }

    public Employee fromDtoToEntity(EmployeeDto Dto) {
        return Employee.builder()
                .firstName(Dto.firstName())
                .lastName(Dto.lastName())
                .dateOfBirth(Dto.dateOfBirth())
                .age(Dto.age())
                .mobileNumber(Dto.mobileNumber())
                .emailAddress(Dto.emailAddress())
                .build();

    }
}
