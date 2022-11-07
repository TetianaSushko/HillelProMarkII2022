package com.hillel.lesson_08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ALvsLL {

    /*
    1_000_000 (List)
    100_000  (put in center by one element per time)

    AL -> O(1) + O(n) -> O(n)
    LL -> O(n) + O(1) -> O(n)
     */
    public static void main(String[] args) {

        List<String> al = new ArrayList<>();
        List<String> ll = new LinkedList<>();

        int listSize = 500_000;
        int inputSize = 50_000;
        int count = 5;

        for (int i =0; i < count; i++){
            al.clear();
            ll.clear();
            for (int j = 0; j < listSize; j++){
                al.add("" + j);
                ll.add("" + j);
            }

            // AL add
            double start = System.currentTimeMillis();
            for (int j = 0; j < inputSize; j++){
                al.add(al.size()/2, String.valueOf(j));
            }
            System.out.println("AL [" + i +"] --> " + (System.currentTimeMillis() - start));

            // AL add
             start = System.currentTimeMillis();
            for (int j = 0; j < inputSize; j++){
                ll.add(ll.size()/2, String.valueOf(j));
            }
            System.out.println("LL [" + i +"] --> " + (System.currentTimeMillis() - start));

            System.out.println("---------------");

        }

    }
}
