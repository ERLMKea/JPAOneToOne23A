package org.example.jpaonetoone23a.controller;

import org.example.jpaonetoone23a.model.User;
import org.example.jpaonetoone23a.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<User> getUsers() {
        return userRepository.findAll();
    }

}
