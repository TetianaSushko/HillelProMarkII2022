package com.hillel.lesson_14.task;

import com.hillel.lesson_14.stream_cont.TermOperation;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeWordInText {
    //16.  В некотором предложении текста слова заданной длины заменить указанной подстрокой,
    //длина которой может не совпадать с длиной слова.

    static String TEXT = "test_word";
    static String TEXT_EXAMPLE = "test word 231 3465435 345345 234 1245 3456 12345243 q345234";


    public static void main(String[] args) {
        int lenght = 4;

        System.out.println(Arrays.stream(TEXT_EXAMPLE.split(" "))
                .map(w -> w.length() == lenght ? TEXT : w)
                .collect(Collectors.joining(" ")));

    }
}
