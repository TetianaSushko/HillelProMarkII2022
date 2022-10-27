package com.hillel.lesson_05.task;

import java.util.Arrays;

public class WhiteSpaceRemover {
    // Напишите Java-программу для удаления всех пробелов из строки без использования replace().
    public static void main(String[] args) {
        String str = "   Hello World Напишите Java-программу для удаления всех " +
                "пробелов из строки без использования replace().";

        String[] mass = str.split(" ");
        System.out.println(Arrays.toString(mass));

        String result = "";
        for(String s : mass) result = result.concat(s);

        System.out.println(result);
    }
}
