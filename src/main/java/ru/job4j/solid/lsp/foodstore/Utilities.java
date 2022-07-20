package ru.job4j.solid.lsp.foodstore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Utilities {
    public static double getPercentsOfExpired(Food food) {

        LocalDate now = LocalDate.now();

        double totalLifetime = food.getCreateDate().until(food.getExpiryDate(), ChronoUnit.DAYS);
        double lifetimePassed = food.getCreateDate().until(now, ChronoUnit.DAYS);

        return lifetimePassed / totalLifetime * 100.0;
    }
}
