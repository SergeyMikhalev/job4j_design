package ru.job4j.solid.lsp.foodstore;

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
}
