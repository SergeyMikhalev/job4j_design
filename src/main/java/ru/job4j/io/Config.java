package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(s -> (s.trim().length() > 0) && (!s.startsWith("#"))).forEach(this::parseStringToMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseStringToMap(String s) {
        String[] strings = s.split("=", 2);
        if (strings.length < 2 || strings[0].isEmpty() || strings[1].isEmpty()) {
            throw new IllegalArgumentException("Illegal string argument -> " + s);
        }
        values.put(strings[0], strings[1]);
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));

    }

}
