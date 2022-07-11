package ru.job4j.gc.prof;

import java.util.Random;

public class SortingMenu {
    public static void main(String... args) {
        Data data = new RandomArray(new Random());
        Sort sort = new InsertSort();

        data.insert(250_000);
        sort.sort(data);
    }

}
