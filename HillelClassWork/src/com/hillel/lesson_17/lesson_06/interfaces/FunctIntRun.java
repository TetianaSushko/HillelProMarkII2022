package com.hillel.lesson_17.lesson_06.interfaces;

public class FunctIntRun {
    public static void main(String[] args) {
        FunctInt fi = (srt) -> System.out.println(srt.toUpperCase());

        fi.print("aaaa");
        fi.print("bbb");
        fi.print("cccc");
        fi.print("ssss");

        fi = (str) -> System.out.println("test");

        fi.print("aaaa");
        fi.print("bbb");
        fi.print("cccc");
        fi.print("ssss");

    }
}
