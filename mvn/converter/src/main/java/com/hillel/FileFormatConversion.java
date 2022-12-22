package com.hillel;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileFormatConversion {

    //определяем какие файлы есть в директории
    List<String> getFilePath(Path path) throws IOException;

    //Валидация
    List<String> getFileValidPath(List<String> filesPath);

    //Конвертация
    long fileConvert(Path path) throws IOException;

    //Cохранение сконвертировано файла
    String saveResult(String content) throws IOException;

    //Логирование работы програмы

   // file.json -> file.yaml; 10c; old_size -> new_size
    //file1.yaml -> file1.json; 5c; old_size1 -> new_size1
}
