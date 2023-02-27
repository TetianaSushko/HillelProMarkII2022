package com.exchange.service;

import com.exchange.dto.*;
import com.exchange.entity.CurrencyEnum;

import java.util.List;

public interface WalletService {

    UserWalletsDto getUserWallets(String phone);
    UserWalletsDto createWallet (WalletRequest walletRequest);
}
