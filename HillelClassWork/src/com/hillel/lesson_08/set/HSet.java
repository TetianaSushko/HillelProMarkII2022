package com.hillel.lesson_08.set;

import java.util.HashSet;
import java.util.Set;

public class HSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(5);

        System.out.println(set.add("1 asdas"));
        System.out.println(set.add("1 asd")); // false
        System.out.println(set.add("2 asda"));
        System.out.println(set.add("3 fhg"));
        System.out.println(set.add("4 rty"));
        System.out.println(set.add("5 gh"));
        System.out.println(set.add("6 gh"));
        System.out.println(set.add("7 dfgh"));
        System.out.println(set.add("8 dfh"));

        System.out.println(set);

        int i = 1;
        int count = 0;
        String value = null;
        for (String s : set){
            if (count++ == i) value = s;
        }

        System.out.println(value);
    }
}
