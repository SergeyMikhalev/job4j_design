package ru.job4j.solid.isp.menu;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;
    Menu menu = new SimpleMenu();

    @Before
    public void fullFillMenu() {
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);

    }

    @Test
    public void whenAddThenReturnSame() {
        assertEquals(
                new Menu.MenuItemInfo(
                        "Сходить в магазин", List.of("Купить продукты"), STUB_ACTION, "1."
                ),
                menu.select("Сходить в магазин").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Купить продукты", List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."
                ),
                menu.select("Купить продукты").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Покормить собаку", List.of(), STUB_ACTION, "2."
                ),
                menu.select("Покормить собаку").get()
        );
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    public void whenSelectNotExisting() {
        assertTrue(menu.select("Отжаться 100 раз").isEmpty());
    }

    @Test
    public void whenPrintAll() {
        String expected = """
                1.Сходить в магазин
                --1.1.Купить продукты
                ----1.1.1.Купить хлеб
                ----1.1.2.Купить молоко
                2.Покормить собаку
                """;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        MenuPrinter mp = new SimpleMenuPrinter();
        mp.print(menu);

        System.setOut(old);

        assertEquals(baos.toString(), expected.replace("\n", System.lineSeparator()));

    }

}
