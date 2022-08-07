package ru.job4j.solid.isp.menu;

import java.util.function.Consumer;

public class SimpleMenuPrinter implements MenuPrinter {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Override
    public void print(Menu menu) {
        menu.forEach((Menu.MenuItemInfo e) -> System.out.println(e.getNumber() + e.getName()));
    }

}




