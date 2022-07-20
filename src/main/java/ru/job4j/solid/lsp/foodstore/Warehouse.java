package ru.job4j.solid.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private ArrayList storage = new ArrayList(10);
    private final static double QUALITY_BOUND = 25.0;

    @Override
    public List<Food> getAllFood() {
        return storage;
    }

    @Override
    public boolean storeFood(Food food) {
        boolean result = false;
        if (Utilities.getPercentsOfExpired(food) < QUALITY_BOUND) {
            result = storage.add(food);
        }
        return result;
    }
}
