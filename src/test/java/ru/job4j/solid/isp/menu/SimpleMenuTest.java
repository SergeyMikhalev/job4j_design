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
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);

    }

    @Test
    public void whenAddThenReturnSame() {
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

    @Test
    public void whenSelectNotExisting() {
        assertTrue(menu.select("�������� 100 ���").isEmpty());
    }

    @Test
    public void whenPrintAll() {
        String expected = """
                1.������� � �������
                --1.1.������ ��������
                ----1.1.1.������ ����
                ----1.1.2.������ ������
                2.��������� ������
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
