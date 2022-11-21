package com.hillel.lesson_12.exception;


import com.hillel.lesson_04.Run;

public class TC {
    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("1");
            if (true)
//            if (false)
                throw new RuntimeException();
            System.out.println("2");
        } catch (RuntimeException ex) {
            System.out.println("3");
        } finally {
            System.out.println("4");
        }
//        Thread.sleep(50);
        System.out.println("5");
    }
}
