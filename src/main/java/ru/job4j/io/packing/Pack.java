package ru.job4j.io.packing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Pack {

    public static void main(String[] args) throws IOException {
        PackParams packParams = null;

        try {
            packParams = PackParamsValidator.validate(args);
        } catch (IllegalArgumentException e) {
            printHintOnWrongKeys();
        }

        if (packParams != null) {
            PackSearcher packSearcher = new PackSearcher(packParams.getExcludeExtension());
            Files.walkFileTree(Path.of(packParams.getSourceDirectory()), packSearcher);
            new Zip().packFiles(packSearcher.getFiles(), Path.of(packParams.getTargetZIP()));
        }

    }

    private static void printHintOnWrongKeys() {
        System.out.println("Неверно заданы ключи работы приложения");
        System.out.println("Верный формат -d=c:\\xxx\\ -e=.xxx -o=xxx.zip");
        System.out.println("где");
        System.out.println("-d - directory - которую мы хотим архивировать.");
        System.out.println("-e - exclude - исключить файлы с расширением xxx.");
        System.out.println("-o - output - во что мы архивируем.");
        System.out.println("примечание. расширение должно начинаться с точки");
    }

}
