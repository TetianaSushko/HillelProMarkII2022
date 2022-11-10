package com.hillel.lesson_09.stone;

import java.util.ArrayList;
import java.util.List;

/*
6. Камни. Определить иерархию драгоценных и полудрагоценных камней.
Отобрать камни для ожерелья. Подсчитать общий вес (вкаратах) и стоимость.
Провести сортировку камней ожерелья на основе ценности.
Найти камни в ожерелье, соответствующие заданному диапазону параметров прозрачности.

наменование
драгоценных и полудрагоценных;
стоимость
вес
прозрачность
 */
public class StoneRun {
    public static void main(String[] args) {
        List<Stone>  stones = new ArrayList<>();
        stones.add(new Stone("1", true, 0.5, 2000, 0.7));
        stones.add(new Stone("2", true, 0.5, 1000, 0.1));
        stones.add(new Stone("1", true, 0.5, 2000, 0.2));
        stones.add(new Stone("3", false, 0.5, 1000, 0.3));
        stones.add(new Stone("1", true, 0.5, 2000, 0.4));
        stones.add(new Stone("4", true, 0.5, 1000, 0.5));
        stones.add(new Stone("1", true, 0.5, 2000, 0.6));


        StoneService ss = new StoneService();

       double price = ss.getWeigh(stones);
       System.out.println(price);

//        System.out.println(ss.sortByPrice(stones));
        System.out.println(ss.getClarity(stones, 0.4, 0.7));



    }
}
