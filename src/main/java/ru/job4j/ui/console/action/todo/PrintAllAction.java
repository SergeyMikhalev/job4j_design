package ru.job4j.ui.console.action.todo;


import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.solid.isp.menu.MenuPrinter;
import ru.job4j.solid.isp.menu.SimpleMenuPrinter;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.input.Input;
import ru.job4j.ui.console.output.Output;

public class PrintAllAction implements UserAction {

    private final Output out;

    public PrintAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Print list ====";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        MenuPrinter menuPrinter = new SimpleMenuPrinter();
        menuPrinter.print(menu);
        return true;
    }
}
