package com.exchange.service.impl;

import com.exchange.dto.*;
import com.exchange.entity.*;
import com.exchange.exceptions.CurrencyExistException;
import com.exchange.exceptions.NotEnoughtMoneyException;
import com.exchange.exceptions.UserNotFoundException;
import com.exchange.repository.NotificationRepository;
import com.exchange.repository.TransactionRepository;
import com.exchange.repository.UserRepository;
import com.exchange.repository.WalletRepository;
import com.exchange.service.WalletService;
import com.exchange.telegram.TelegramBot;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
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
    private final NotificationRepository notificationRepository;

    private final TelegramBot telegramBot;

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

        String verificationCode = RandomStringUtils.randomAlphabetic(6);
        Transaction transaction = new Transaction()
                .setReceiver(transferDto.getPhoneNumber())
                .setAmount(transferDto.getAmmount())
                .setType(TransactionTypeEnum.PUT)
                .setUpdateAt(LocalDate.now())
                .setCurrency(transferDto.getCurrency())
                .setCode(verificationCode)
                .setStatus(TransactionStatusEnum.PENDING);


        telegramBot.sendMessage(user.getTelegramChatId(), verificationCode);

        transactionRepository.save(transaction);

        notificationRepository.save(new Notification()
                .setType(NotificationTypeEnum.PUT)
                .setUser(user)
                .setContent(String.format("User try put %s %s to wallet. Status pending",
                        transferDto.getAmmount(),
                        transferDto.getCurrency())));

        return transaction.getId();
    }

    @Override
    public Long putMoneyVerification(VerificationDto verificationDto) {
        User user = userRepository.findByPhoneNumber(verificationDto.phoneNumber());

        Transaction transaction = transactionRepository.findById(verificationDto.transactionId())
                .orElseThrow(NullPointerException::new);

        if (transaction.getCode().equals(verificationDto.code())) {
            Wallet wallet = walletRepository.findByUserAndCurrency(user, transaction.getCurrency());
            wallet.setAmmount(wallet.getAmmount().add(transaction.getAmount()));
            walletRepository.save(wallet);
            transaction.setCode(null);
            transaction.setStatus(TransactionStatusEnum.EXECUTED);
            transactionRepository.save(transaction);

            notificationRepository.save(new Notification()
                    .setType(NotificationTypeEnum.PUT)
                    .setUser(user)
                    .setContent(String.format("User put %s %s to wallet. Status execute",
                            transaction.getAmount(),
                            transaction.getCurrency())));
        }
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
