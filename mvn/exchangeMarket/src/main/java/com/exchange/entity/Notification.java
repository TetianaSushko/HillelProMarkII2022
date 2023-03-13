package com.exchange.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class Notification {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private NotificationTypeEnum type;

    private String content;

    private User user;

    private LocalDate createAt = LocalDate.now();
}
