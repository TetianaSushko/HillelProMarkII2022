package com.hillel.lesson_04.ex;

/*
В N этажного жилом доме M квартир.
Определить, на каком этаже и в каком подъезде
находится квартира с заданным номером.
 4 квартиры на этаже
 */
// 9 этажей 108 квартир
public class FloorFlatCalculate {
    private int florNumber = 9;
    private int florCountFlat = 4;
    private int flatNumber = 108;

    public static void main(String[] args) {
//        FloorFlatCalculate ffc = new FloorFlatCalculate();
//        System.out.println(ffc.getPodezd(35));
//        System.out.println(ffc.getFlor(72));
    }

    private  int getPodezd(int flatNumber){
        if (flatNumber % florNumber * florCountFlat == 0) {
            return  (flatNumber / (florNumber * florCountFlat)) ;
        } else {
            return  (flatNumber / (florNumber * florCountFlat)) + 1;
        }
    }

    private  int getFlor(int flatNumber){
        if (flatNumber % florCountFlat == 0) {
            return  (flatNumber / florCountFlat) ;
        } else {
            return  (flatNumber /  florCountFlat) + 1;
        }
    }
}
