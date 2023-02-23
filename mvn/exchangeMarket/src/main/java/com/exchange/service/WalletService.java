package com.exchange.service;

import com.exchange.dto.UserDto;
import com.exchange.dto.UserRecord;
import com.exchange.dto.UserWalletsDto;
import com.exchange.dto.WalletRequest;

import java.util.List;

public interface WalletService {

    UserWalletsDto getUserWallets(String phone);
    UserWalletsDto createWallet (WalletRequest walletRequest);



}
