package ru.job4j.io.packing;

import ru.job4j.io.ArgsName;

public class Pack {

    public static void main(String[] args) {

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
