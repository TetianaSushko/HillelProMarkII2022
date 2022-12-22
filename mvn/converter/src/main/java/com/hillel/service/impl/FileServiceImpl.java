package com.hillel.service.impl;

import com.hillel.service.FileService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;

public class FileServiceImpl implements FileService {
    @Override
    public List<File> getFilesPath(Path path) {
        File f = new File(String.valueOf(path));
        List<File> filePath = new ArrayList<>();
        if (f.isDirectory()) {
            filePath = Arrays.asList(Objects.requireNonNull(path.toFile().listFiles()));
        }
        return getFileValidPath(filePath, List.of("json", "yaml"));
    }

    private List<File> getFileValidPath(List<File> filesPath, List<String> extensions) {
        List<File> fileValidPath = new ArrayList<>();
        for (File s : filesPath) {
            for (String ext : extensions)
            if (s.getName().toLowerCase().endsWith(ext.toLowerCase())) {
                fileValidPath.add(s);
            }
        }
        return fileValidPath;
    }

    @Override
    public void saveToFile(File file, boolean append, String data) throws IOException {
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream outputStream =
                new FileOutputStream(file, append);
        outputStream.write(data.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String readFromFile(Path path) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public boolean isFileFormat(File file, String ext){
        return file.getName().toLowerCase().endsWith(ext.toLowerCase());
    }

    @Override
    public String getFileName(File file) {
        return file.getName().split("\\.")[0];
    }
}
