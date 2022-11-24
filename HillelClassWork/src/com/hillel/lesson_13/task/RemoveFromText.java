package com.hillel.lesson_13.task;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

// Из текста удалить все слова заданной длины, начинающиеся c заданой буквы.
public class RemoveFromText {

    private final static String TEXT = "Скажите зачем эта маленькая княгиня сказал князь Василий " +
            "тихо Анне Павловне почему он особенно умного Мы после поговорим сказала Анна Павловна" +
            " улыбаясь";

    public static void main(String[] args) {
        int length = 6;
        String startLetter = "с";
        AtomicReference<String> result = new AtomicReference<>("");
        Arrays.stream(TEXT.split(" "))
                .filter(s -> (!(s.length() == length && s.toLowerCase().startsWith(startLetter))))
                .forEach(u -> result.set(result + " " + u));

        System.out.println(TEXT);
        System.out.println(result);
    }


}
