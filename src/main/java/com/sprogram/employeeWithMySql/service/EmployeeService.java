package com.sprogram.employeeWithMySql.service;

import com.sprogram.employeeWithMySql.entity.Employee;
import com.sprogram.employeeWithMySql.exception.EmployeeAlreadyExistException;
import com.sprogram.employeeWithMySql.exception.EmployeeNotExistException;
import com.sprogram.employeeWithMySql.exception.MobileNumberNotAllowedException;
import com.sprogram.employeeWithMySql.exception.NotFoundEmployeeException;
import com.sprogram.employeeWithMySql.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee saveEmployee(Employee newEmployee) {
        log.info("Save new employee: [{}]", newEmployee);

        if (employeeRepository.existsByMobileNumber(newEmployee.getMobileNumber())) {

            throw new EmployeeAlreadyExistException("User already exist with this mobile phone number  ");

        }

        Employee saved = employeeRepository.save(newEmployee);

        log.info("after saving [{}]", saved);

        return saved;

    }


    public List<Employee> findAllEmployees() {

        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {

        return employeeRepository.findById(id).orElse(null);

    }
   /* public Employee findEmployeeByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }*/


    public String deleteEmployeeById(Long id) {
        if (findEmployeeById(id) == null) {
            throw new EmployeeNotExistException("Employee with this id is not exist");
        }
        employeeRepository.deleteById(id);
        return "Employee was deleted " + id;
    }

    public Employee updateEmployee(Long id, Employee employee) {

        //Employee em = employeeRepository.findById(id).orElseThrow(()->new NotFoundEmployeeException("User not found"));
        Employee em = findEmployeeById(id);
        if (em == null) {
            throw new EmployeeNotExistException("There is no Employee with this id");
        }
        if (!(employee.getMobileNumber().equals(em.getMobileNumber())) && (employeeRepository.existsByMobileNumber(employee.getMobileNumber()))) {
            throw new MobileNumberNotAllowedException("This Mobile Number is not allowed");
        }

        em.setFirstName(employee.getFirstName());
        em.setLastName(employee.getLastName());
        em.setAge(employee.getAge());
        em.setDateOfBirth(employee.getDateOfBirth());
        em.setMobileNumber(employee.getMobileNumber());
        em.setEmailAddress(employee.getEmailAddress());
        return employeeRepository.save(em);


    }
    // Boolean updateEmployee = employeeRepository.existsByMobileNumber(employee.getMobileNumber());

        /*if (!employeeRepository.existsByMobileNumber(employee.getMobileNumber())) {
            throw new NotFoundEmployeeException("User not found");
        } else {
            Employee em = employeeRepository.findByMobileNumber(employee.getMobileNumber());
            em.setFirstName(employee.getFirstName());
            em.setLastName(employee.getLastName());
            em.setDateOfBirth(employee.getDateOfBirth());
            em.setAge(employee.getAge());
            return employeeRepository.save(em);
        }*/
        /*Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName((employee.getLastName()));
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        return employeeRepository.save(existingEmployee);*/
    // }

}
