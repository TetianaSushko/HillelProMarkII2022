package com.hillel.lesson_13.optional;

import com.hillel.lesson_13.streamExample.businessObject.User;

import java.util.Optional;

public class OptionaConstr {
    public static void main(String[] args) {
        User us = new User();

        Optional<User> oUser = Optional.of(us);
        oUser.ifPresent(oUser.get()::printUser);


        oUser.ifPresent(us::printUser);
        Optional<User> user = Optional.ofNullable(us);

        Optional<User> userEmpty = Optional.empty();

    }
}
