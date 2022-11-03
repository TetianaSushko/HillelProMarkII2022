package com.hillel.lesson_06.hw;

public class RunSt {

    public static void main(String[] args) {
        StudentService ss = new StudentService();
        ss.print(DataGenerator.getStudentArray());
        ss.print(DataFromDB.getStudentArray());
    }
}
