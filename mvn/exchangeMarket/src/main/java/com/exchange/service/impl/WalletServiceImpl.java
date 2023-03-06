package com.exchange.service.impl;

import com.exchange.dto.*;
import com.exchange.entity.*;
import com.exchange.exceptions.CurrencyExistException;
import com.exchange.exceptions.NotEnoughtMoneyException;
import com.exchange.exceptions.UserNotFoundException;
import com.exchange.repository.TransactionRepository;
import com.exchange.repository.UserRepository;
import com.exchange.repository.WalletRepository;
import com.exchange.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

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


    @Override
    public Long putMoney(TransferDto transferDto) {
        User user = userRepository.findByPhoneNumber(transferDto.getPhoneNumber());
        Transaction transaction = new Transaction()
                .setReceiver(transferDto.getPhoneNumber())
                .setAmount(transferDto.getAmmount())
                .setType(TransactionTypeEnum.PUT)
                .setUpdateAt(LocalDate.now())
                .setCurrency(transferDto.getCurrency())
                .setStatus(TransactionStatusEnum.PENDING);



        Wallet wallet = walletRepository.findByUserAndCurrency(user, transferDto.getCurrency());
        wallet.setAmmount(wallet.getAmmount().add(transferDto.getAmmount()));
        walletRepository.save(wallet);

        transaction.setStatus(TransactionStatusEnum.EXECUTED);
        transactionRepository.save(transaction);

        System.out.println(transaction);

        return transaction.getId();
    }

    @Override
    public void getMonet(TransferDto transferDto) {
        User user = userRepository.findByPhoneNumber(transferDto.getPhoneNumber());
        Wallet wallet = walletRepository.findByUserAndCurrency(user, transferDto.getCurrency());
        if (wallet.getAmmount().compareTo(transferDto.getAmmount()) == -1)
            throw new NotEnoughtMoneyException();

        wallet.setAmmount(wallet.getAmmount().subtract(transferDto.getAmmount()));
        walletRepository.save(wallet);
    }
}
