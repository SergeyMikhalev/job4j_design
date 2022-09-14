package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    public String load(String key) {
        System.out.println("Загрузка из файла....");
        String fullPathString = cachingDir + "\\" + key;
        Path fullPath = Path.of(cachingDir, key);

        System.out.println("Поиска файла ->" + fullPath);
        String result = "";
        if (fullPath.toFile().exists()) {
            try {
                System.out.println("Файл найден. Попытка чтения...");
                result = Files.readString(fullPath);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            throw new IllegalArgumentException("Файл " + fullPathString + " не найден!");
        }
        return result;
    }

    public void setCachingDir(String cachingDir) {
        this.cachingDir = cachingDir;
    }
}


