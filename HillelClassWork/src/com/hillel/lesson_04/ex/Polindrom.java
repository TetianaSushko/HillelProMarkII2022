package com.hillel.lesson_04.ex;

import java.util.Locale;

public class Polindrom {

    private static final String TEXT = "А роза упала на лапу Азора";
    private static final String TEXT_F = "afrefa";

    public static void main(String[] args) {
        System.out.println(isPolindrom(TEXT));
        System.out.println(isPolindrom(TEXT_F));
    }

    public static boolean isPolindrom(String str) {
        String text = str.toLowerCase(Locale.ROOT).replace(" ", "");
        for (int i = 0; i < text.length()/2; i++){
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) return false;
        }
        return true;
    }
}
