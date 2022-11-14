package com.sprogram.employeeWithMySql.repository;

import com.sprogram.employeeWithMySql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Employee findByLastName(String lastName);


    Boolean existsByMobileNumber(String mobileNumber);

    /*@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Employee e WHERE e.mobileNumber = :mobileNumber")
    boolean existsByEmail(@Param("email") String email);*/

    Employee findByMobileNumber(String mobileNumber);
}
