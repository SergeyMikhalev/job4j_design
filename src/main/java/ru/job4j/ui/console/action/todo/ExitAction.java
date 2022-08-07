package ru.job4j.ui.console.action.todo;


import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.input.Input;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exit ====";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        return false;
    }
}
