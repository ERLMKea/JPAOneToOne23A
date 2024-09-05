package org.example.jpaonetoone23a.controller;

import org.example.jpaonetoone23a.model.Employee;
import org.example.jpaonetoone23a.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{name}")
    List<Employee> getEmpoyeesName(@PathVariable String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postUser(@RequestBody Employee employee) {
        System.out.println(employee);
        return employeeRepository.save(employee);
    }




}
