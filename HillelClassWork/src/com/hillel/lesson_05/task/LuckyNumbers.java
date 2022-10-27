package com.hillel.lesson_05.task;

public class LuckyNumbers {

    public boolean calculateLuckyNumber(String value){
        if (value.length() % 2 != 0) return false;

        String[] mass = value.split("");
        int r = 0;
        int l = 0;

        for (int i = 0; i < mass.length/2; i++){
            r += Integer.parseInt(mass[i]);
            l += Integer.parseInt(mass[mass.length - i - 1]);
        }
        return r == l;
    }

    public static void main(String[] args) {
        LuckyNumbers ln = new LuckyNumbers();
        System.out.println(ln.calculateLuckyNumber("11123111"));
    }
}
