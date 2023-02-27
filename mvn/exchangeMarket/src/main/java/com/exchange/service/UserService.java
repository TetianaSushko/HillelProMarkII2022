package com.exchange.service;

import com.exchange.dto.UserView;
import com.exchange.dto.UserDto;
import com.exchange.dto.UserRecord;
import com.exchange.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    Long createUser(UserRecord user);

    List<UserDto> getAllUsers();

    Page<User> getUsers(Pageable page);

    Page<UserDto> getActiveUsers(Pageable page);

    UserDto getUserById(Long id);

    List<UserView> getUserWalletByPhone(String phone);
}
