package com.hillel.lesson_04.ex;

import java.util.Arrays;

/*
 Заполнить массив N числами последовательности Фибоначчи
  0 - 1
  1 - 1
  2 - 2
  3 - 3
  4 - 5
  5 - 8
  .......
 */
public class Fibonacci {
    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        System.out.println(getFibonachiNumber(50));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("--------");
        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(getFibanachiRows(50)));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static int getFibonachiNumber(int number){
        if (number == 0 || number == 1) return 1;
        return getFibonachiNumber(number - 2) + getFibonachiNumber(number - 1);
    }

    private static int[] getFibanachiRows(int number){
        int[] massFibon = new int[number];

        if (number > 0) {
            massFibon[0] = 1;
        }

        if (number > 1) {
            massFibon[1] = 1;
        }

        for (int i = 2; i < massFibon.length; i++) {
            massFibon[i] = massFibon[i - 1] + massFibon[i - 2];
        }
        return massFibon;
    }
}
