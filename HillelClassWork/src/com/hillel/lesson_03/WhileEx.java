package com.hillel.lesson_03;


public class WhileEx {
    public static void main(String[] args) {

        whileExample();
        System.out.println("-------");
        doWhileExample();
    }

    static void whileExample(){
        byte a = 100;
        byte result = 0;
        while (a < 100) { // false then nothing
            System.out.println(a++);
        }
    }

    static void doWhileExample(){
        byte a = 100;
        byte result = 0;
        do {
            System.out.println(a++);
        }while (a < 100);

    }
}
