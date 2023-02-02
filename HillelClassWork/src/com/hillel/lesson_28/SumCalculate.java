package com.hillel.lesson_28;

/*
    2.Create a function (digitSum) that accepts an integer and calculates the sum of it's digits.
    If the sum is greater than 9 repeats the calculation of the sum of it's digits until we get sum < 10.
    Returns the final sum.

    examples
    10 -> 1 + 0 = 1                                            ... returns 1
    38 -> 3 + 8 = 11 -> 1 + 1 = 2                              ... returns 2
    785 -> 7 + 9 + 5 = 21 -> 2 + 1 = 3                         ... returns 3
    99892 -> 9 + 9 + 8 + 9 + 2 = 37 -> 3 + 7 = 10 -> 1 + 0 = 1 ... returns 1
*/
public class SumCalculate {
    public static void main(String[] args) {
        System.out.println(calc(99892));
    }

    public static int calc(Integer num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num = num / 10;
        }
        if (sum >= 10) return calc(sum);
        return sum;
    }
}
