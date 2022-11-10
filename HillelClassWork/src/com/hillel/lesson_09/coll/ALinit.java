package com.hillel.lesson_09.coll;

import java.util.ArrayList;

public class ALinit {
    public static void main(String[] args) {
        ArrayList<String> arrS = new ArrayList<>(15); // 10
        ArrayList<String> arrSt = new ArrayList<>(3_000_000); // 10


        System.out.println(arrS.size());
        arrS.set(4, null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        System.out.println(arrS.size());

        arrS.get(100);

    }
}
