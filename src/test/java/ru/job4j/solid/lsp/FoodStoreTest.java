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
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(10),
                1000.0, 10.0);

        controlQuality.put(food);
        Assert.assertEquals(List.of(food), warehouse.getAllFood());
        Assert.assertTrue(trash.getAllFood().isEmpty());
        Assert.assertTrue(shop.getAllFood().isEmpty());
    }

    @Test
    public void whenStoreInTrash() {
        Food food = Food.getInstance("Bread",
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(1),
                1000.0, 10.0);

        controlQuality.put(food);
        Assert.assertEquals(List.of(food), trash.getAllFood());
        Assert.assertTrue(warehouse.getAllFood().isEmpty());
        Assert.assertTrue(shop.getAllFood().isEmpty());
    }


    @Test
    public void whenStoreInShopWithoutDiscount() {
        Food food = Food.getInstance("Bread",
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(10),
                1000.0, 10.0);

        controlQuality.put(food);
        Assert.assertEquals(List.of(food), shop.getAllFood());
        Assert.assertEquals(1000.0, food.getPrice(), 0.0);
        Assert.assertTrue(warehouse.getAllFood().isEmpty());
        Assert.assertTrue(trash.getAllFood().isEmpty());
    }

    @Test
    public void whenStoreInShopWithDiscount() {
        Food food = Food.getInstance("Bread",
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(2),
                1000.0, 10.0);

        controlQuality.put(food);
        Assert.assertEquals(List.of(food), shop.getAllFood());
        Assert.assertEquals(900.0, food.getPrice(), 0.0);
        Assert.assertTrue(warehouse.getAllFood().isEmpty());
        Assert.assertTrue(trash.getAllFood().isEmpty());
    }


    @Test
    public void whenMultipleFoodInstances() {
        Food bread = Food.getInstance("Bread",
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(2),
                1000.0, 10.0);

        Food meat = Food.getInstance("Meat",
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(2),
                600.0, 15.0);

        Food fish = Food.getInstance("Fish",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(20),
                1000.0, 5.0);

        controlQuality.put(fish);
        controlQuality.put(meat);
        controlQuality.put(bread);

        Assert.assertEquals(List.of(meat), trash.getAllFood());
        Assert.assertEquals(List.of(fish), warehouse.getAllFood());
        Assert.assertEquals(List.of(bread), shop.getAllFood());

    }

    @Test
    public void whenUseResort() {
        Food bread = Food.getInstance("Bread",
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(2),
                1000.0, 10.0);

        Food fish = Food.getInstance("Fish",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(20),
                1000.0, 5.0);

        controlQuality.put(fish);
        controlQuality.put(bread);

        bread.setCreateDate(LocalDate.now());
        fish.setExpiryDate(LocalDate.now());

        controlQuality.resort();

        Assert.assertEquals(List.of(fish), trash.getAllFood());
        Assert.assertEquals(List.of(bread), warehouse.getAllFood());

    }

}
