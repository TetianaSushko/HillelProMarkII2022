package com.exchange.service.impl;

import com.exchange.dto.*;
import com.exchange.entity.CurrencyEnum;
import com.exchange.entity.User;
import com.exchange.entity.Wallet;
import com.exchange.exceptions.CurrencyExistException;
import com.exchange.exceptions.UserNotFoundException;
import com.exchange.repository.UserRepository;
import com.exchange.repository.WalletRepository;
import com.exchange.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    @Override
    public UserWalletsDto getUserWallets(String phone) {

        User user = Optional.ofNullable(userRepository.findByPhoneNumber(phone)).orElseThrow(UserNotFoundException::new);

        List<Wallet> userWallets = walletRepository.findAllByUser(user);

        return UserWalletsDto.builder()
                .userDto(UserDto.fromEntity(user))
                .userWallets(userWallets.stream().map(WalletDto::fromEntity).toList())
                .build();

    }

    @Override
    public UserWalletsDto createWallet(WalletRequest walletRequest) {
        User user = Optional.ofNullable(userRepository.findByPhoneNumber(walletRequest.phone())).orElseThrow(UserNotFoundException::new);

        List<Wallet> userWallets = walletRepository.findAllByUser(user);

        long count = userWallets.stream().filter(w -> w.getCurrency().equals(CurrencyEnum.valueOf(walletRequest.currencyISO()))).count();

        if (count > 0) throw new CurrencyExistException();

        walletRepository.save(new Wallet()
                .setUser(user)
                .setCurrency(CurrencyEnum.valueOf(walletRequest.currencyISO()))
                .setAmmount(BigDecimal.ZERO)
                .setLastUpdate(new Timestamp(System.currentTimeMillis())));

        return getUserWallets(walletRequest.phone());
    }


}
