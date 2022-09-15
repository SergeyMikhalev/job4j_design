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
    protected String load(String key) {
        System.out.println("�������� �� �����....");
        Path fullPath = Path.of(cachingDir, key);

        System.out.println("������ ����� ->" + fullPath);
        String result = "";
        try {
            System.out.println("���� ������. ������� ������...");
            result = Files.readString(fullPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setCachingDir(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public String getCachingDir() {
        return cachingDir;
    }
}


