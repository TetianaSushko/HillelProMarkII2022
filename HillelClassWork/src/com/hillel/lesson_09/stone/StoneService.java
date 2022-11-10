package com.hillel.lesson_09.stone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
6. Камни. Определить иерархию драгоценных и полудрагоценных камней.
Отобрать камни для ожерелья. Подсчитать общий вес (вкаратах) и стоимость.
Провести сортировку камней ожерелья на основе ценности.
Найти камни в ожерелье, соответствующие заданному диапазону параметров прозрачности.
 */
public class StoneService {

    public double getWeigh(List<Stone> stones){
        double totalWeight = 0;
        for (Stone s : stones) {
            totalWeight += s.getWeightCarat();
        }
        return totalWeight;
    }

    public double getPrice(List<Stone> stones){
        double totalPrice = 0;
        for (Stone s : stones) {
            totalPrice += s.getPrice();
        }
        return totalPrice;
    }

    public List<Stone> sortByPrice(List<Stone> stones){
        stones.sort(Comparator.comparing(Stone::getPrice));
        return stones;
    }

    public List<Stone> getClarity(List<Stone> stones, double min, double max){
        List<Stone> rez = new ArrayList<>();
        for (Stone s : stones){
            if (s.getClarity() <= max && s.getClarity() >= min){
                rez.add(s);
            }
        }
        return rez;
    }





}
