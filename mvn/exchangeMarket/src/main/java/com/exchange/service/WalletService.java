package com.exchange.service;

import com.exchange.dto.*;
import com.exchange.entity.CurrencyEnum;

import java.util.List;

public interface WalletService {

    UserWalletsDto getUserWallets(String phone);
    UserWalletsDto createWallet (WalletRequest walletRequest);
    Long putMoney(TransferDto transferDto);
    Long putMoneyVerification(VerificationDto verificationDto);
    Long getMoney(TransferDto transferDto);
    Long getMoneyVerification(VerificationDto verificationDto);
    Long exchangeMoney(ExchangeDto exchangeDto);
    Long exchangeMoneyVerification(VerificationDto verificationDto);
}
