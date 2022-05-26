package ru.job4j.io.packing;

import ru.job4j.io.ArgsName;

import java.io.File;

public class PackParamsValidator {

    public static PackParams validate(String[] args) {
        ArgsName argsName = ArgsName.of(args);

        String directory = argsName.get("d");
        String targetFile = argsName.get("o");
        String exclude = argsName.get("e");

        File file = new File(directory);
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }

        if (!file.isDirectory()) {
            throw new IllegalArgumentException();
        }

        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException();
        }

        return new PackParams(directory, targetFile, exclude);
    }


}
