package ru.job4j.ui.console.action.todo;


import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.input.Input;
import ru.job4j.ui.console.output.Output;

public class CreateAction implements UserAction {

    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        String name = input.askStr("Enter name: ");
        String parentName = input.askStr("Enter parent node name. ROOT for top of list: ");

        if ("ROOT".equals(parentName)) {
            parentName = null;
        }

        boolean result = menu.add(parentName, name, System.out::println);

        if (result) {
            out.println("Item successfully added!");
        } else {
            out.println("Some problems, cant add!");
        }
        return true;
    }
}
