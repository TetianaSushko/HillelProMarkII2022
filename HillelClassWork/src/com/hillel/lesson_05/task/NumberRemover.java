package com.hillel.lesson_05.task;

import java.util.Arrays;

//Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива
//(пропусков быть не должно). 1 2 3 4 5 6 4 5 4 - (4) -> 1 2 3 5 6 5
public class NumberRemover {
    public static void main(String[] args) {
        Integer[] intMass = {1, 2, 3, 4, 5, 6, 4, 5, 4};
        int removeNumber = 4;

        int count = 0;

        for (Integer i : intMass){
            if (i == removeNumber) count++;
        }
        System.out.println(count);

        Integer[] intMasNew = new Integer[intMass.length - count];

        count = 0;
        for (Integer mass : intMass) {
            if (!mass.equals(removeNumber)) {
                intMasNew[count++] = mass;
            }
        }
        System.out.println(Arrays.toString(intMasNew));
    }
}
