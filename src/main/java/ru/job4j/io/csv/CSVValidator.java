package ru.job4j.io.csv;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVValidator {
    public static CSVParams validate(ArgsName args) {

        Path source = Path.of(args.get("path"));
        if (!source.toFile().exists()) {
            throw new IllegalArgumentException(" Неверно указан параметр запуска path ");
        }

        String delimiter = args.get("delimiter");
        String[] columns = args.get("filter").split(",");
        String out = args.get("out");

        boolean printToConsole = out.equals("stdout");

        Path targetFile = null;

        if (!printToConsole) {
            targetFile = Path.of(out);
            try {
                if (!targetFile.toFile().exists()) {
                    if (!targetFile.toFile().createNewFile()) {
                        throw new IllegalArgumentException("Неверно указан файл назначения");
                    }
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Неверно указан файл назначения");
            }
        }
        return new CSVParams(source, delimiter, List.of(columns), printToConsole, targetFile);
    }
}
