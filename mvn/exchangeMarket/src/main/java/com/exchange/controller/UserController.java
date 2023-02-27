package com.exchange.controller;


import com.exchange.dto.UserView;
import com.exchange.dto.UserRecord;
import com.exchange.dto.UserDto;
import com.exchange.dto.UserWalletRequest;
import com.exchange.entity.User;
import com.exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

     @GetMapping("/users/pag")
    public Page<User> getAllUsers(@RequestParam int page, @RequestParam int size) {
        return userService.getUsers(PageRequest.of(page, size));

    }     @GetMapping("/users/active")
    public Page<UserDto> getActiveUsers(@RequestParam int page, @RequestParam int size) {
        return userService.getActiveUsers(PageRequest.of(page, size));
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user/wallet")
    public List<UserView> getUserById(@RequestBody UserWalletRequest user) {
        return userService.getUserWalletByPhone(user.phone());
    }
}
