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

    public static void printHintOnWrongKeys() {
        System.out.println("""
                Неверно заданы ключи работы приложения
                Верный формат -d=c:\\\\xxx\\\\ -e=.xxx -o=xxx.zip
                где
                -d - directory - которую мы хотим архивировать.
                -e - exclude - исключить файлы с расширением xxx.
                -o - output - во что мы архивируем.
                примечание. расширение должно начинаться с точки
                """);

    }


}
