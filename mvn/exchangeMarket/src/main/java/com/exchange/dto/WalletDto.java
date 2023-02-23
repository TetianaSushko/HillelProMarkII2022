package com.exchange.dto;

import com.exchange.entity.CurrencyEnum;
import com.exchange.entity.User;
import com.exchange.entity.Wallet;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class WalletDto {
    private CurrencyEnum currency;

    private BigDecimal ammount;

    public static WalletDto fromEntity(Wallet wallet) {
        return WalletDto.builder()
                .ammount(wallet.getAmmount())
                .currency(wallet.getCurrency())
                .build();
    }
}
