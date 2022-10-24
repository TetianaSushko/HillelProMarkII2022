package com.hillel.lesson_04.ex;

// count sum of odd numbers 12235 - 1 + 3 + 5 = 9
public class ChetNumber {
    public int result = 0;

    public static void main(String[] args) {
        Integer number = 12235;
        ChetNumber cn = new ChetNumber();
        System.out.println(cn.calculate(number));
    }

    private int calculate(Integer value){
        int lastNumber = value % 10;
        if (lastNumber % 2 != 0) result += lastNumber;
        if (value / 10 > 0) {
            calculate(value / 10);
        }
        return result;
    }

}
