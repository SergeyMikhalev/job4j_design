package ru.job4j.solid.lsp.foodstore;

import java.time.LocalDate;

public class Main {
    public static void main(String... args) {
        LocalDate date1 = LocalDate.of(2022, 2, 2);
        LocalDate date2 = LocalDate.of(2022, 8, 1);

        System.out.println(Utilities.getPercentsOfExpired(Food.getInstance("Eda", date1, date2, 10.0, 10.0)));
    }
}
