package com.hillel.lesson_03;

public class SwitchExample {
    public static void main(String[] args) {
        int week = 5;

        System.out.println(day((byte)week));
//        System.out.println(dayNumber("sunday1"));
//        System.out.println(dayNumber(week));
    }

    static String day(byte i) {
        return switch (i) {
            case 1, 2, 3, 4, 5 -> "Work day";
            case 6, 7 -> "Weekend";
            default -> "End off earth ....";
        };
    }

    static int dayNumber(String day){
        return switch (day.toLowerCase()) {
            case "понедельник", "monday" -> 1;
            case "sunday" -> 2;
            default -> 3;
        };
    }
}
