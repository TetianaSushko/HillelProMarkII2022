package com.hillel.lesson_03.ex;


// reverse number 111112344 - 443211111
public class Reverse {
    public static void main(String[] args) {
        int value = 111222;
        Reverse reverse = new Reverse();
        System.out.println(value);
        System.out.println("-------");
        System.out.println(reverse.reverse(value));
    }

    private int reverse(int value){
        char[] chars = String.valueOf(value).toCharArray();

        for (int i = 0; i < chars.length/2; i++){
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
