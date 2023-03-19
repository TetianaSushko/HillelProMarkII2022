package com.hillel.service;

import com.hillel.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
