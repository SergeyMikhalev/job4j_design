package ru.job4j.ui.console.action;


import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.ui.console.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Menu menu);
}
