package com.exchange.controller;


import com.exchange.dto.UserRecord;
import com.exchange.dto.UserDto;
import com.exchange.service.UserService;
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

    private final UserService userService;

    @PostMapping("/user")
    public Long addUser(@RequestBody UserRecord user) {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

}
