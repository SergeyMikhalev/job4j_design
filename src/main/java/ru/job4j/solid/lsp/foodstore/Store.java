package ru.job4j.solid.lsp.foodstore;

import java.util.List;

public interface Store {
    public List<Food> getAllFood();

    public boolean storeFood(Food food);
}
