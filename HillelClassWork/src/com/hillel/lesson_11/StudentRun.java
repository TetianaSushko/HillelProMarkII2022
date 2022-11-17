package com.hillel.lesson_11;

public class StudentRun {
    public static void main(String[] args) {
        Student st = new Student()
                .setId(10)
                .setName("Alex")
                .setAge(40);

        System.out.println(st);
    }
}
