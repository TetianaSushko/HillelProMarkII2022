package com.exchange.mapper;

import com.exchange.dto.UserDto;
import com.exchange.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "fullName", expression = "java(getFullName(user))")
    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    default String getFullName(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}
