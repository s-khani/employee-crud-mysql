package com.sprogram.employeeWithMySql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EmployeeWithMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeWithMySqlApplication.class, args);
    }

}
