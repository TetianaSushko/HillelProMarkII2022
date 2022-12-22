package com.hillel;

import com.google.gson.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.String.valueOf;

public class ConverYamlInJson implements FileFormatConversion{

    @Override
    public List<String> getFilePath(Path path) throws IOException {
        File f = new File(String.valueOf(path));
        List<String> filePath = null;
        if (f.isDirectory()) {
            filePath = Arrays.asList(path.toFile().list());
        } else {
            filePath = new ArrayList<>();
        }
        return filePath;
    }

    @Override
    public List<String> getFileValidPath(List<String> filesPath) {
        List<String> fileValidPath = null;
        for (String s : filesPath){
            if(!s.endsWith(".json")){
                fileValidPath = new ArrayList<>(Collections.singleton(s));
            }
        }
        return fileValidPath;
    }

    @Override
    public long fileConvert(Path path) throws IOException{
        Yaml yaml = new Yaml(new Constructor(Map[].class));
        String yamlStr = readToString(valueOf(path));
        Map[] obj = yaml.load(yamlStr);

        Gson gson = new Gson();
        String json = gson.toJson(obj);

        String s =  Paths.get("").toAbsolutePath().toString();
        String fileName = "src/main/java/com/hillel/convertet/User_Data.json";
        File file = new File(s, File.separator.concat(fileName));

        OutputStream outputStream =
                new FileOutputStream(file, false);
        outputStream.write(json.getBytes(StandardCharsets.UTF_8));
        long size = file.length();
        return size;
    }

    @Override
    public String saveResult(String content) throws IOException {
        String s =  Paths.get("").toAbsolutePath().toString();
        String fileName = "result.log";
        File file = new File(s, File.separator.concat(fileName));

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileOutputStream fos = new FileOutputStream(file, true);
        fos.write(content.getBytes(StandardCharsets.UTF_8));
        return content;
    }

    public String readToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
