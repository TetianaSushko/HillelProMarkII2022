package com.hillel.lesson_28;

import java.util.Arrays;
import java.util.Optional;

/*
        Create a function (findSeven) that takes an array of numbers and return "Found"

        if the character 7 appears in the array of the numbers. Otherwise, return "there is no 7 in the array".

        String findSeven(int[] array);

        Examples :
        findSeven([1, 2, 3, 4, 5, 6, 7]) ➞ "Found"
        // 7 contains the number seven.
        findSeven([8, 6, 33, 100]) ➞ "there is no 7 in the array"
        // None of the items contain 7 within them.
        findSeven([2, 55, 60, 97, 86]) ➞ "Found"
        // 97 contains the number seven.
 */
public class FindSeven {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {8, 6, 33, 100};
        int[] arr3 = {2, 55, 60, 97, 86};
        int[] arrTest = {70};

//        System.out.println(findSeven(arr1));
//        System.out.println(findSeven(arr2));
//        System.out.println(findSeven(arr3));
//        System.out.println("-----------------------");
//        System.out.println(findSevenStream(arr1));
//        System.out.println(findSevenStream(arr2));
//        System.out.println(findSevenStream(arr3));
//        System.out.println("-----------------------");
//        System.out.println(findSevenRecursion(arr1));
//        System.out.println(findSevenRecursion(arr2));
//        System.out.println(findSevenRecursion(arr3));
        System.out.println(findSevenRecursion(arrTest));

    }

    public static String findSeven(int[] array){
        for (int i : array){
            String value = String.valueOf(i);
            if(value.contains("7")) return "found";
        }
        return "there is no 7 in the array";
    }

    public static String findSevenStream(int[] array){
        Optional<String> v = Arrays.stream(array).mapToObj(String::valueOf).filter(s -> s.contains("7")).findFirst();
        return v.isPresent() ? "found" :  "there is no 7 in the array";
    }

    public static String findSevenRecursion(int[] array){
        for (int i : array){
            if (isContainSven(i)) return "found";
        }
        return "there is no 7 in the array";
    }

    private static boolean isContainSven(int num){
        if  (num == 7 || num % 10 == 7 ) {
            return true;
        } else if ((num / 10) > 0) {
            System.out.println(num / 10);
            return isContainSven(num / 10);
        }
        return false;
    }


}
