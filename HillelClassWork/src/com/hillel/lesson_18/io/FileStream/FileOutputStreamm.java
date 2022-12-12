package com.hillel.lesson_18.io.FileStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamm {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream =
                new FileOutputStream("HillelClassWork/src/com/hillel/lesson_18/io/FileStream/output.txt", false);

        outputStream.write("override\n".getBytes(StandardCharsets.UTF_8));
    }
}
