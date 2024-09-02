package org.example.jpaonetoone23a.controller;

import org.example.jpaonetoone23a.model.Employee;
import org.example.jpaonetoone23a.model.User;
import org.example.jpaonetoone23a.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

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

}
