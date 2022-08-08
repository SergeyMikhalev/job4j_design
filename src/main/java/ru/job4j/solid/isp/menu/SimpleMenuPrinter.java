package ru.job4j.solid.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static final String DELIMITER = "--";

    @Override
    public void print(Menu menu) {
        menu.forEach((Menu.MenuItemInfo e) -> {
            String addition = DELIMITER.repeat(e.getNumber().split("\\.").length-1);
            System.out.println(addition + e.getNumber() + e.getName());
        });
    }

}




