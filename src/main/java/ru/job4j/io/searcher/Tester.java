package ru.job4j.io.searcher;

public class Tester {

    public static void main(String... args) {
        String str = "vasi?.jpg";

        System.out.println(str);
        System.out.println("^" + str.replace(".", "[.]")
                .replace("*", ".*")
                .replace("?", ".") + "$"
        );
    }
}
