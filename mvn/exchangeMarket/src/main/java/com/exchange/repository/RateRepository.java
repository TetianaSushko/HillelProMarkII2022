package com.exchange.repository;

import com.exchange.entity.CurrencyEnum;
import com.exchange.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    List<Rate> findByCurrency(CurrencyEnum currencyEnum);

    Rate findFirstByCurrencyOrderByReceiveDesc(CurrencyEnum currencyEnum);
}
