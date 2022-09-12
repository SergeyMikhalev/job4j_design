package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String fullPathString = cachingDir + "\\" + key;
        Path fullPath = Path.of(fullPathString);
        String result = "";
        if (fullPath.toFile().exists()) {
            try {
                result = Files.readString(fullPath);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            throw new IllegalArgumentException("Файл " + fullPathString + " не найден!");
        }
        return result;
    }

}


