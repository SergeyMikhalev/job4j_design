package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Illegal string argument -> " + key);
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            String[] validatedStrings = validate(s);
            values.put(validatedStrings[0], validatedStrings[1]);
        }
    }

    private String[] validate(String s) {
        if (!s.startsWith("-")) {
            throw new IllegalArgumentException("Illegal string argument -> " + s);
        }
        s = s.replaceFirst("-", "");
        String[] substrings = s.split("=", 2);
        if (substrings.length < 2 || substrings[0].isEmpty() || substrings[1].isEmpty()) {
            throw new IllegalArgumentException("Illegal string argument -> " + s);
        }
        return substrings;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
