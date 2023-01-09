package com.hillel.lesson_18.io.FileStream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream =
                new FileInputStream("HillelClassWork/src/com/hillel/lesson_18/io/FileStream/input.txt");
        int size = inputStream.available();
        System.out.println("file size : " + size);
        for (int i = 0; i < size; i++){
//            Thread.sleep(500);
            System.out.print((char) inputStream.read());
        }
        inputStream.close();

        // Output stream
        OutputStream outputStream =
                new FileOutputStream("HillelClassWork/src/com/hillel/lesson_18/io/FileStream/output.txt");

        String str = "Stepurko Oleksandr";

        outputStream.write(str.getBytes(StandardCharsets.UTF_8));

        outputStream.close();


    }
}
