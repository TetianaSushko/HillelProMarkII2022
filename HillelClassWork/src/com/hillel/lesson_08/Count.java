package com.hillel.lesson_08;

// Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}».
// Проверить правильность расстановки скобок. Использовать стек.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Count {
    public static void main(String[] args) {
        String str = "()[]{}()()[]{}";
        String strHard = "[([]{}){({})()}[]{}]";
        System.out.println(isCorrect(str));
    }


    private static boolean isCorrect(String value){
        if (value.length() % 2 != 0) return false;
        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList(value.split("")));
        while (stack.size() != 0){
            String v1 = stack.pop();
            String v2 = stack.pop();

            if (!(v1.equals("}") && v2.equals("{")
                    ||v1.equals("]") && v2.equals("[")
                    ||v1.equals(")") && v2.equals("("))
            ) return false;
        }


        return true;
    }
}
