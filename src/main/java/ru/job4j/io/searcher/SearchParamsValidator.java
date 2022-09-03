package ru.job4j.io.searcher;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SearchParamsValidator {
    public static SearchParams validate(String[] args) {

        ArgsName argsName = ArgsName.of(args);

        String directoryString = argsName.get("d");
        String resultFileString = argsName.get("o");
        String maskTypeString = argsName.get("t");
        String mask = argsName.get("n");

        File directory = new File(directoryString);
        if (!directory.exists()) {
            throw new IllegalArgumentException();
        }

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException();
        }

        File file = new File(resultFileString);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        if (!List.of("mask", "name", "regex").contains(maskTypeString)) {
            throw new IllegalArgumentException();
        }

        SearchParams.SearchType type = SearchParams.SearchType.MASK;
        if (maskTypeString.equals("name")) {
            type = SearchParams.SearchType.FULL_NAME;
        }
        if (maskTypeString.equals("regex")) {
            type = SearchParams.SearchType.REGEXP;
        }

        return new SearchParams(directoryString, mask, type, resultFileString);
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
