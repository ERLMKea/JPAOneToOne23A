package org.example.jpaonetoone23a.model;

import org.example.jpaonetoone23a.repositories.EmployeeRepository;
import org.example.jpaonetoone23a.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    void deleteAll() {
        employeeRepository.deleteAll();
        userRepository.deleteAll();
    }

    void insert1user() {
        User us1 = new User();
        us1.setEmail("casc@gmail.dk");
        us1.setPassword("hej");
        userRepository.save(us1);
        Employee emp1 = new Employee();
        emp1.setName("casc");
        emp1.setBorn(LocalDateTime.now());
        emp1.setGender(Gender.MALE);
        emp1.setUser(us1);
        employeeRepository.save(emp1);
    }

    @Test
    void testNormalUser() {
        deleteAll();
        User us1 = new User();
        us1.setEmail("casc@gmail.dk");
        us1.setPassword("hej");
        userRepository.save(us1);
        Employee emp1 = new Employee();
        emp1.setName("casc");
        emp1.setBorn(LocalDateTime.now());
        emp1.setGender(Gender.MALE);
        emp1.setUser(us1);
        employeeRepository.save(emp1);
        assertEquals(1, employeeRepository.findAll().size());
    }


    @Test
    void testCascadeUser() {
        deleteAll();
        insert1user();
        List<Employee> lst = employeeRepository.findEmployeeByName("casc");
        User usr = lst.get(0).getUser();
        userRepository.delete(usr);
        assertEquals(0, employeeRepository.findAll().size());
    }


}