package com.hillel.lesson_08.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LHSet {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        System.out.println(set.add("One rterte"));
        System.out.println(set.add("Two werwe"));
        System.out.println(set.add("Three wer"));
        System.out.println(set.add("Four werew"));
        System.out.println(set.add("Five werwe"));

        System.out.println(set.toString());
    }
}
