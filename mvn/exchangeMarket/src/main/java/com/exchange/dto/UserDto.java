package com.exchange.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.exchange.entity.User;

import java.util.Date;

@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;
    private boolean isActive;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFirstName().concat(" ").concat(user.getLastName()))
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .dateOfBirth(user.getDateOfBirth())
                .build();


    }
}
