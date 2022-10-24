package com.sprogram.employeeWithMySql.service;

import com.sprogram.employeeWithMySql.entity.Employee;
import com.sprogram.employeeWithMySql.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> saveAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee findEmployeeByLastName(String lastName){
        return employeeRepository.findByLastName(lastName);
    }


    public String deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
        return "Employee was deleted " + id;
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName((employee.getLastName()));
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setDob(employee.getDob());
        return employeeRepository.save(existingEmployee);
    }

}
