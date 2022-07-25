package ru.job4j.solid.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> storage = new ArrayList<>();

    private final static double QUALITY_LOWER_BOUND = 25.0;
    private final static double QUALITY_UPPER_BOUND = 100.0;
    private final static double QUALITY_DISCOUNT_BOUND = 75.0;

    @Override
    public List<Food> getAllFood() {
        return new ArrayList<>(storage);
    }

    @Override
    public boolean storeFood(Food food) {
        boolean result = false;
        double expiredRate = Utilities.getPercentsOfExpired(food);
        if (expiredRate >= QUALITY_LOWER_BOUND && expiredRate < QUALITY_UPPER_BOUND) {
            if (expiredRate > QUALITY_DISCOUNT_BOUND) {
                food.setPrice(food.getPrice() * (1.0 - food.getDiscount() / 100.0));
            }
            result = storage.add(food);
        }
        return result;
    }
}
