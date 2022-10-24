package com.sprogram.employeeWithMySql.controller;

import com.sprogram.employeeWithMySql.entity.Employee;
import com.sprogram.employeeWithMySql.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/employees")
public class employeeController {
    private final EmployeeService employeeService;

    public employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        log.info("add a new employee");
        return  employeeService.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        log.info("add all employees");
        return employeeService.saveAllEmployees(employees);
    }
     @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("employeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee em =  employeeService.findEmployeeById(id);
        if (em == null){
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(em,HttpStatus.OK);
    }

    @GetMapping("/{lastName}")
    public Employee getEmployeeByLastName(@PathVariable String lastName){
        return employeeService.findEmployeeByLastName(lastName);
    }



    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
      return  employeeService.updateEmployee(employee);

    }

    @DeleteMapping("/{id}")
    public String delEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }


}
