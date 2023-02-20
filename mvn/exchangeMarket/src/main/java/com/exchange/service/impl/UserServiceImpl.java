package com.exchange.service.impl;

import com.exchange.dto.UserDto;
import com.exchange.dto.UserRecord;
import com.exchange.entity.CurrencyEnum;
import com.exchange.entity.User;
import com.exchange.entity.Wallet;
import com.exchange.exceptions.UserNotFoundException;
import com.exchange.mapper.UserMapper;
import com.exchange.repository.UserRepository;
import com.exchange.repository.WalletRepository;
import com.exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final WalletRepository walletRepository;
    private final UserMapper userMapper;

    @Override
    public Long createUser(UserRecord user) {
        User save = userRepository.save(
                new User()
                        .setLastName(user.last_name())
                        .setFirstName(user.first_name())
                        .setEmail(user.email())
                        .setPhoneNumber(user.phone())
                        .setActive(false));


        Wallet uah = walletRepository.save(new Wallet()
                .setUser(save)
                .setCurrency(CurrencyEnum.UAH)
                .setAmmount(BigDecimal.ZERO)
                .setLastUpdate(new Timestamp(System.currentTimeMillis())));


        Wallet usd = walletRepository.save(new Wallet()
                .setUser(save)
                .setCurrency(CurrencyEnum.USD)
                .setAmmount(BigDecimal.ZERO)
                .setLastUpdate(new Timestamp(System.currentTimeMillis())));

        walletRepository.save(uah);
        walletRepository.save(usd);


        return save.getId();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }
}
