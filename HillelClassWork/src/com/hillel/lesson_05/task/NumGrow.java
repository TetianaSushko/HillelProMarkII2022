package com.hillel.lesson_05.task;

// Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько,
// найти первое из них.
public class NumGrow {
    public static void main(String[] args) {
        int[] mass = {1, 25, 12345, 125}; // -> 12345
        int count = 0;
        for (int i : mass) {
            String[] m = String.valueOf(i).split("");
            if (m.length > 1) {
                for (int j = 1; j < m.length; j++) {
                    if ((Integer.parseInt(m[j]) - Integer.parseInt(m[j - 1])) != 1) {
                        break;
                    }
                }
            }
            count = i;
        }
        System.out.println(count);
    }
}
