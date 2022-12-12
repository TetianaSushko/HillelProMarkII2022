package com.hillel.lesson_18;

import java.util.zip.CRC32;

public class CRC {
    public static void main(String[] args) {
        String input = "Hello World!";
        String input1 = "hello world!";

        CRC32 crc = new CRC32();
        crc.update(input.getBytes());
        System.out.println("input:"+input);
        System.out.println("CRC32:"+crc.getValue());

        crc.update(input1.getBytes());
        System.out.println("input1:"+input1);
        System.out.println("CRC32:"+crc.getValue());


    }
}
