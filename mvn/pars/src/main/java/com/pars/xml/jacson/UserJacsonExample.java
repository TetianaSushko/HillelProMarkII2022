package com.pars.xml.jacson;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pars.User;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class UserJacsonExample {
    public static void main(String[] args) throws IOException {
        File file = new File(Objects.requireNonNull(UserJacsonExample.class.getClassLoader().getResource("phoneBookOne.xml")).getFile());
//        File file = new File(Objects.requireNonNull(UserJacsonExample.class.getClassLoader().getResource("phoneBook_1.xml")).getFile());
        XmlMapper xmlMapper = new XmlMapper();
//        User[] value = xmlMapper.readValue(file, User[].class);
        User value = xmlMapper.readValue(file, User.class);
        System.out.println(value);

//        Arrays.stream(value).forEach(System.out::println);
    }
}
