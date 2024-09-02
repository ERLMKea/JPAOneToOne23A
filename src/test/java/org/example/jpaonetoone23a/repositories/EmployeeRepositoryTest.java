package org.example.jpaonetoone23a.repositories;

import org.example.jpaonetoone23a.model.Employee;
import org.example.jpaonetoone23a.model.User;
import org.h2.jdbc.JdbcSQLException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void testAtLeastOneViggo() {
        List<Employee> lst = employeeRepository.findEmployeeByName("Viggo");
        assertTrue(lst.size()>0);
    }

    @Test
    void testDeleteUserWithEmployee() {
        List<Employee> lst = employeeRepository.findEmployeeByName("Viggo");
        Employee emp1 = lst.get(0);
        assertEquals("Viggo", emp1.getName());
        User usr = emp1.getUser();
        assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> userRepository.delete(usr));
    }


}