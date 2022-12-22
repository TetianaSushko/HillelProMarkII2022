package com.hillel;
/*
    Написать приложение которое производит конвертацию форматов Json <--> Yaml:

    на вход приложения в виде аргумента программы принимаем расположение директории
    где находятся файлы, если аргумент отсутствует то происходит анализ текущей папки
    валидируем формат (YAML, JSON)
    сохраняем полученный файл в папке converted (старое имя + новое расширение)
    результаты конвертации сохраняем в файле result.log в формате
    имя_файла -> новое_имя_файла, длительность конвертации, старый размер -> новый размер

    если конвертация не возможно надо записать что файл не сконвертировался

    работа с файлами
    конвертация

 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws IOException {

        FileFormatConversion jsonInYaml = new ConverJsonInYaml();
        FileFormatConversion yamlInJson = new ConverYamlInJson();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter directory path...");
        String folderPath = sc.nextLine();
        sc.close();

        //получаем  виде аргумента программы расположение директории где находятся файлы
        Path path = Path.of(Paths.get(folderPath).toAbsolutePath().toString());
        List<String> filesPath = jsonInYaml.getFilePath(path);

        //валидируем формат (YAML, JSON) оставляя JSON
        List<String> fileValidPath = jsonInYaml.getFileValidPath(filesPath).stream().toList();
        String fValidPath = null;
        for (String s : fileValidPath) {
            fValidPath = s;
        }

        //получаем расположение директории где находится файл JSON
        Path path1 = Path.of(String.valueOf(path), File.separator.concat(fValidPath));

        //конвертируем файл Json --> Yaml, сохраняем полученный файл в папке converted
        long start = System.currentTimeMillis();
        long size1 = jsonInYaml.fileConvert(path1)/1024;
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        File file = new File(String.valueOf(path1));
        long size = file.length()/1024;

        String content = "file.json -> file.yaml; "+ elapsed + " mc; old size " +
                size + "kb, new size " + size1 + "kb\n";

        //результаты конвертации сохраняем в файле result.log
        System.out.println(jsonInYaml.saveResult(content));

        //валидируем формат (YAML, JSON) оставляя YAML
        List<String> fileValidPathY = yamlInJson.getFileValidPath(filesPath).stream().toList();
        String fValidPathY = null;
        for (String s : fileValidPathY) {
            fValidPathY = s;
        }

        //получаем расположение директории где находится файл YAML
        Path path1Y = Path.of(path + "/" + fValidPathY);

        //конвертируем файл Yaml --> Json, сохраняем полученный файл в папке converted
        long startY = System.currentTimeMillis();
        long size1Y = yamlInJson.fileConvert(path1Y)/1024;
        long finishY = System.currentTimeMillis();
        long elapsedY = finishY - startY;

        File fileY = new File(String.valueOf(path1Y));
        long sizeY = fileY.length()/1024;

        String contentY = "file.yaml -> file.json; "+ elapsedY + " mc; old size " +
                sizeY + "kb, new size " + size1Y + "kb\n";

        //результаты конвертации сохраняем в файле result.log
        System.out.println(jsonInYaml.saveResult(contentY));
    }
}
