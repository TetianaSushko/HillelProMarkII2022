package com.hillel.lesson_05.task;

import java.util.Locale;

/**
 * Напишите программу, которая выводит на экран числа от 1 до 100.
 * При этом вместо чисел, кратных трем, программа должна выводить слово «Fizz»,
 * а вместо чисел, кратных пяти — слово «Buzz». Если число кратно и 3, и 5,
 * то программа должна выводить слово «FizzBuzz»
 */
public class From1to100 {
    public static void print() {
        String result = "";

        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0 & i % 5 == 0) {
                result = result.concat("FizzBuzz ");
            } else if (i % 5 == 0) {
                result = result.concat("Buzz ");
            } else if (i % 3 == 0) {
                result = result.concat("Fizz ");
            } else {
                result = result.concat(String.valueOf(i + " "));
            }
        }

        System.out.println(result);
    }

    public static void printElse() {
        for (int i = 1; i < 101; i++) {
            String result = "";
            boolean number = true;
            if (i % 5 == 0) {
                result = result.concat("Buzz");
                number = false;
            }
            if (i % 3 == 0) {
                result = result.concat("Fizz");
                number = false;
            }
            if (number) {
                result = result.concat(i + "");
                number = true;
            }
            System.out.println(result);
        }


    }

    public static void main(String[] args) {
        printElse();
    }
}

