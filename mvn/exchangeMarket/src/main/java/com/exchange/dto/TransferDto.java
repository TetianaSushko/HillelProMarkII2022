package com.exchange.dto;

import com.exchange.entity.CurrencyEnum;
import com.exchange.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class TransferDto {
    private String phoneNumber;
    private String distPhoneNumber;
    private CurrencyEnum currency;
    private BigDecimal ammount;

}
