package org.example.jpaonetoone23a.config;

import org.example.jpaonetoone23a.model.Employee;
import org.example.jpaonetoone23a.model.Gender;
import org.example.jpaonetoone23a.model.User;
import org.example.jpaonetoone23a.repositories.EmployeeRepository;
import org.example.jpaonetoone23a.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        if (employeeRepository.findAll().size() == 0) {
            User us1 = new User();
            us1.setEmail("viggo@gmail.com");
            us1.setPassword("adfadsf");
            userRepository.save(us1);

            Employee emp1 = new Employee();
            emp1.setName("Viggo");
            emp1.setBorn(LocalDateTime.now());
            emp1.setGender(Gender.MALE);
            emp1.setUser(us1);
            employeeRepository.save(emp1);
            //nu har vi 1 user og 1 employee i databasen

            us1.setUserID(0); //sæt pk til 0 så får vi ny user i tabel
            us1.setEmail("kurt@gmail.com");
            us1.setPassword("adfasdf");
            userRepository.save(us1); //insert new user
            emp1.setId(0);
            emp1.setName("Kurt");
            employeeRepository.save(emp1);

            us1.setUserID(0);
            us1.setEmail("egon@gmail.com");
            us1.setPassword("adfadfasfd");
            userRepository.save(us1);
            emp1.setId(0);
            emp1.setName("Egon");
            employeeRepository.save(emp1);

        }



    }
}


