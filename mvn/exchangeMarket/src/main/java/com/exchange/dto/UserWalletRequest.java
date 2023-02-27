package com.exchange.dto;

import com.exchange.entity.CurrencyEnum;

public record UserWalletRequest(String phone, CurrencyEnum currencyIso) {
}
