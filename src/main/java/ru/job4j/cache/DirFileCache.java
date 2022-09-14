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
        System.out.println("�������� �� �����....");
        String fullPathString = cachingDir + "\\" + key;
        Path fullPath = Path.of(cachingDir, key);

        System.out.println("������ ����� ->" + fullPath);
        String result = "";
        if (fullPath.toFile().exists()) {
            try {
                System.out.println("���� ������. ������� ������...");
                result = Files.readString(fullPath);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            throw new IllegalArgumentException("���� " + fullPathString + " �� ������!");
        }
        return result;
    }

    public void setCachingDir(String cachingDir) {
        this.cachingDir = cachingDir;
    }
}


