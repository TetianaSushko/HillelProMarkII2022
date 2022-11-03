package com.hillel.lesson_07.task;

/*
    Напишите Java-программу для проверки является ли введенное число - числом Армстронга.
    Прежде всего, нам нужно понять, что такое число Армстронга.
    Число Армстронга это число, значение которого равно сумме цифр,
    из которых оно состоит, возведенных в степень, равную количеству
    цифр в этом числе.

    Как пример - число 371:
    371 = 3*3*3 + 7*7*7 + 1*1*1 = 27 + 343 + 1 = 371
    Если у вас число четырехзначное:
    8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8 = 4096 + 16 + 0 + 4096 = 820812.

    вывести первые N чисел, N задать с клавиатуры
 */
public class ArmstrongNumber {
    public static void main(String[] args) {

        int num = 10;
        int count = 0;
        int counter = 0;
        do {
            if(isArmstrongNumber(counter)){
                count++;
                System.out.println(counter);
            }
            counter++;
        } while (count != num);

    }

    public static boolean isArmstrongNumber(Integer number){
        String[] valuesStr = String.valueOf(number).split("");

        int pow = valuesStr.length;
        int result = 0;

        for (String s : valuesStr) {
            result += Math.pow(Integer.parseInt(s), pow);
        }
        return number.equals(result);
    }
}
