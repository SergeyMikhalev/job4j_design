package ru.job4j.solid.lsp.foodstore;

import java.util.List;

public interface Store {
    List<Food> getAllFood();

    boolean storeFood(Food food);
}
