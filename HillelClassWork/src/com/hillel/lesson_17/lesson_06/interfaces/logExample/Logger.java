package com.hillel.lesson_17.lesson_06.interfaces.logExample;

public interface Logger {

    void printLog(String msg);

    String xxx();

    default void print() {
        System.out.println("print from interface");
    }
}
