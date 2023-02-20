package com.exchange.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class UserShortDto {
    private Long id;
    private String firstName;
    private String LastName;
    private String phoneNumber;

}
