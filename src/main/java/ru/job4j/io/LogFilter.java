package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            in.lines().filter((String s) -> {
                String[] words = s.split(" ");
                return words[words.length - 2].equals("404");
            }).forEach(rsl::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        System.out.println(log);

    }
}