package com.exchange.controller;

import com.exchange.entity.User;
import com.exchange.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/user")
    public Long addUser(@RequestBody User user) {
        User save = userRepository.save(user);
        return save.getId();
    }

     @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
