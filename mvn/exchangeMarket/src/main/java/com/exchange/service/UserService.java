package com.exchange.service;

import com.exchange.dto.UserRecord;
import com.exchange.dto.UserDto;

import java.util.List;

public interface UserService {

    Long createUser(UserRecord user);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);
}
