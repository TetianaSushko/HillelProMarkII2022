package com.exchange.dto;

import com.exchange.entity.CurrencyEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ExchangeDto {
    private String phoneNumber;
    private CurrencyEnum currencyFrom;
    private CurrencyEnum currencyTo;
    private BigDecimal ammount;

}
