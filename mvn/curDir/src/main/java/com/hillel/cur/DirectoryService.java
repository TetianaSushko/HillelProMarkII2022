package main.java.com.hillel.cur;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DirectoryService {

    public List<File> directoryContent(String path){
        File f = new File(path);

        if (f.isDirectory()) {
            return Arrays.asList(f.listFiles());
        } else {
            return new ArrayList<>();
        }
    }

    public void printDir(List<File> files){
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("[D] " + f.getName());
                printDir(directoryContent(f.getAbsolutePath()));
            } else {
                System.out.println("[F] " + f.getName());
            }
        }
    }
}
