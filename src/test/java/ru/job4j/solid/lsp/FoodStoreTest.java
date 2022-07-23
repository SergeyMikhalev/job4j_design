package ru.job4j.solid.lsp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.solid.lsp.foodstore.*;

import java.time.LocalDate;
import java.util.List;

public class FoodStoreTest {

    ControlQuality controlQuality;
    Store warehouse;
    Store trash;
    Store shop;

    @Before
    public void prepareController() {
        warehouse = new Warehouse();
        trash = new Trash();
        shop = new Shop();

        List<Store> stores = List.of(warehouse, trash, shop);
        controlQuality = new ControlQuality(stores);
    }

    @Test
    public void whenStoreInWarehouse() {
        Food food = Food.getInstance("Bread",
                LocalDate.of(2022, 7, 1),
                LocalDate.of(2022, 12, 1),
                1000.0, 10.0);

        controlQuality.put(food);
        Assert.assertEquals(food, warehouse.getAllFood().get(0));
        Assert.assertTrue(trash.getAllFood().isEmpty());
        Assert.assertTrue(shop.getAllFood().isEmpty());
    }

    @Test
    public void whenStoreInTrash() {
        Food food = Food.getInstance("Bread",
                LocalDate.of(2022, 7, 1),
                LocalDate.of(2022, 7, 20),
                1000.0, 10.0);

        controlQuality.put(food);
        Assert.assertEquals(food, trash.getAllFood().get(0));
        Assert.assertTrue(warehouse.getAllFood().isEmpty());
        Assert.assertTrue(shop.getAllFood().isEmpty());
    }


    @Test
    public void whenStoreInShopWithoutDiscount() {
        Food food = Food.getInstance("Bread",
                LocalDate.of(2022, 7, 1),
                LocalDate.of(2022, 7, 31),
                1000.0, 10.0);

        controlQuality.put(food);
        Assert.assertEquals(food, shop.getAllFood().get(0));
        Assert.assertTrue(1000.0 == shop.getAllFood().get(0).getPrice());
        Assert.assertTrue(warehouse.getAllFood().isEmpty());
        Assert.assertTrue(trash.getAllFood().isEmpty());
    }

    @Test
    public void whenStoreInShopWithDiscount() {
        Food food = Food.getInstance("Bread",
                LocalDate.of(2022, 7, 1),
                LocalDate.of(2022, 7, 25),
                1000.0, 10.0);

        controlQuality.put(food);
        Assert.assertEquals(food, shop.getAllFood().get(0));
        Assert.assertTrue(900.0 == shop.getAllFood().get(0).getPrice());
        Assert.assertTrue(warehouse.getAllFood().isEmpty());
        Assert.assertTrue(trash.getAllFood().isEmpty());
    }

}
