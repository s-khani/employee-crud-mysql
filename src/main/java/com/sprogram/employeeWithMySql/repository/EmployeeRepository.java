package com.sprogram.employeeWithMySql.repository;

import com.sprogram.employeeWithMySql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByLastName(String lastName);
}
