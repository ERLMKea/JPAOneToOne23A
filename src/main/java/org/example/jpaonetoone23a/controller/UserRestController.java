package org.example.jpaonetoone23a.controller;
import org.example.jpaonetoone23a.model.User;
import org.example.jpaonetoone23a.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        System.out.println(user);
        return userRepository.save(user);
    }

    @PutMapping("/user")
    public ResponseEntity<User> putUser(@RequestBody User user) {
        Optional<User> usr = userRepository.findById(user.getUserID());
        if (usr.isPresent()) {
            System.out.println(user);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        Optional<User> std = userRepository.findById(id);
        if (std.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


}


