package com.exchange.repository;

import com.exchange.entity.CurrencyEnum;
import com.exchange.entity.User;
import com.exchange.entity.Wallet;
import com.exchange.service.WalletService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findAllByUser(User user);

    Wallet findByUserAndCurrency(User user, CurrencyEnum currency);
}
