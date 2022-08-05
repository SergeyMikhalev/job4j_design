package ru.job4j.solid.isp.menu;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);
        assertEquals(
                new Menu.MenuItemInfo(
                        "������� � �������", List.of("������ ��������"), STUB_ACTION, "1."
                ),
                menu.select("������� � �������").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "������ ��������", List.of("������ ����", "������ ������"), STUB_ACTION, "1.1."
                ),
                menu.select("������ ��������").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "��������� ������", List.of(), STUB_ACTION, "2."
                ),
                menu.select("��������� ������").get()
        );
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

}
