package com.hillel.lesson_08;

public class StackOverFlow {
    public static void main(String[] args) {
        req();
    }

    public static void req(){
        for(;;){
            int i = 0;
            req();
        }
    }
}