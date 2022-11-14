package com.sprogram.employeeWithMySql.controller;

import com.sprogram.employeeWithMySql.converter.EmployeeConverter;
import com.sprogram.employeeWithMySql.dto.EmployeeDto;
import com.sprogram.employeeWithMySql.dto.ErrorResponse;
import com.sprogram.employeeWithMySql.entity.Employee;
import com.sprogram.employeeWithMySql.exception.NotFoundEmployeeException;
import com.sprogram.employeeWithMySql.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeConverter employeeConverter;

    public EmployeeController(EmployeeService employeeService, EmployeeConverter employeeConverter) {

        this.employeeService = employeeService;
        this.employeeConverter = employeeConverter;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EmployeeDto addEmployee(@Valid @RequestBody EmployeeDto newEmployee) {
        log.info("add a new employee");
        var entity = employeeConverter.fromDtoToEntity(newEmployee);
        var saved = employeeService.saveEmployee(entity);
        return employeeConverter.fromEntityToDto(saved);

    }


    @GetMapping()
    public List<EmployeeDto> getAllEmployees() {
        var entities = employeeService.findAllEmployees();
        return entities.stream()
                .map(employee -> employeeConverter.fromEntityToDto(employee))
                .toList();

    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {

        if (employeeService.findEmployeeById(id) == null) {
            throw new NotFoundEmployeeException("User Not found");
        }
        Employee entity = employeeService.findEmployeeById(id);
        return employeeConverter.fromEntityToDto(entity);


    }

   /* @GetMapping("/{lastName}")
    public Employee getEmployeeByLastName(@PathVariable String lastName) {
        return employeeService.findEmployeeByLastName(lastName);
    }*/


    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable(value = "id") Long id, @Valid @RequestBody EmployeeDto employee) {


        Employee entity = employeeConverter.fromDtoToEntity(employee);
        Employee em = employeeService.updateEmployee(id, entity);
        return employeeConverter.fromEntityToDto(em);


    }


    @DeleteMapping("[/{id}")
    public String delEmployeeById(@PathVariable Long id) {

        return employeeService.deleteEmployeeById(id);
    }


}
