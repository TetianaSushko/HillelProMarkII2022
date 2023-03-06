package com.exchange.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.glassfish.grizzly.http.util.TimeStamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    private String sender;

    private String receiver;

    @Column(name = "update_at")
    private LocalDate updateAt;

    private String comment;




}
