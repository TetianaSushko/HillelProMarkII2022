package com.hillel.lesson_03.ex;

import java.util.Scanner;

// count sum of odd numbers 12235 - 1 + 3 + 5 = 9
public class ChetNumber {

    public static void main(String[] args) {
        Integer number = 12235;
        ChetNumber cn = new ChetNumber();
        System.out.println(cn.calculateSplit(number));
    }

    private int calculate(Integer value){
        char[] chars = Integer.toString(value).toCharArray();
        int result = 0;
        for (char c : chars){
            int i = Integer.parseInt(String.valueOf(c));
            if (i % 2 != 0) result += i;
        }
        return result;
    }

    private int calculateSplit(Integer value){
        int result = 0;
        String str = String.valueOf(value);
        for (String s : str.split("")){
            int i = Integer.parseInt(s);
            if (i % 2 != 0) result += i;
        }
        return result;
    }

}
