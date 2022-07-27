package ru.job4j.solid.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> storages;

    public ControlQuality(List<Store> storages) {
        this.storages = storages;
    }

    public void put(Food food) {
        for (Store store : storages) {
            if (store.storeFood(food)) {
                break;
            }
        }
    }

    public void resort() {
        List<Food> allProducts = new ArrayList<>();

        for (Store store : storages) {
            allProducts.addAll(store.getAllFood());
            store.clear();
        }

        allProducts.forEach(this::put);

    }
}
