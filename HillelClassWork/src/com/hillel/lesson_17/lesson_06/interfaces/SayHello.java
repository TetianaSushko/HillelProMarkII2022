package com.hillel.lesson_17.lesson_06.interfaces;

public interface SayHello extends Say{
    @Override
    default void sayHello(){
        System.out.println("say default sayHello ...");
    };
}
