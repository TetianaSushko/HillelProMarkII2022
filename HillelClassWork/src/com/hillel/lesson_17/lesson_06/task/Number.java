package com.hillel.lesson_17.lesson_06.task;

public class Number {
    /*
       Найти число, состоящее только из различных цифр.
       Если таких чисел несколько, найти первое из них.
     */
    public static void main(String[] args) {
        Integer[] intMass = {1232, 132725, 1225, 1234567890, 2658};

        for (Integer i : intMass){
            String srtValue = String.valueOf(i);
            if (srtValue.length() > 10) continue;
            int j = 0;
            for (; j < 10; j++){
                String result = srtValue.replaceAll(String.valueOf(j), "");
                if (srtValue.length() - result.length() > 1) break;
            }
            if (j == 10) {
                System.out.println(srtValue);
                break;
            }

        }

    }
}
