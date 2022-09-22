package ru.job4j.io.searcher;

import ru.job4j.io.ArgsName;
import ru.job4j.io.searcher.filters.MaskSearchFilter;
import ru.job4j.io.searcher.filters.NameSearchFilter;
import ru.job4j.io.searcher.filters.RegExpSearchFilter;
import ru.job4j.io.searcher.filters.SearchFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class SearchParamsValidator {
    public static SearchParams validate(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        String directoryString = argsName.get("d");
        String resultFileString = argsName.get("o");
        String maskTypeString = argsName.get("t");
        String mask = argsName.get("n");

        checkSourceDirectory(directoryString);
        checkTargetFile(resultFileString);
        SearchFilter filter = null;
        switch (maskTypeString) {
            case "mask":
                filter = new MaskSearchFilter(mask);
                break;
            case "name":
                filter = new NameSearchFilter(mask);
                break;
            case "regex":
                filter = new RegExpSearchFilter(mask);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return new SearchParams(Path.of(directoryString), Path.of(resultFileString), filter);
    }

    private static void checkTargetFile(String resultFileString) {
        File file = new File(resultFileString);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void checkSourceDirectory(String directoryString) {
        File directory = new File(directoryString);
        if (!directory.exists()) {
            throw new IllegalArgumentException();
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException();
        }
    }

    public static String getHint() {
        String result = """
                Неверно заданы параметры работы приложения
                Верный формат -d=c:/ -n=*.?xt -t=mask -o=log.txt 
                где
                -d - директория, в которой начинать поиск.
                -n - имя файла, маска, либо регулярное выражение.
                -t - тип поиска: 
                    mask искать по маске, 
                    name по полному совпадение имени, 
                    regex по регулярному выражению.
                -o - результат записать в файл.
                примечание. расширение должно начинаться с точки
                """;
        return result;
    }

}
