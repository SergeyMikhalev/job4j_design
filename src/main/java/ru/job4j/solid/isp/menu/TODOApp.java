package ru.job4j.solid.isp.menu;

import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.action.todo.CreateAction;
import ru.job4j.ui.console.action.todo.ExitAction;
import ru.job4j.ui.console.action.todo.PrintAllAction;
import ru.job4j.ui.console.input.ConsoleInput;
import ru.job4j.ui.console.input.Input;
import ru.job4j.ui.console.input.ValidateInput;
import ru.job4j.ui.console.output.ConsoleOutput;
import ru.job4j.ui.console.output.Output;

import java.util.List;

public class TODOApp {

    public void init(Input input, Menu menu, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Enter select: ");
            UserAction action = actions.get(select);
            run = action.execute(input, menu);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d. %s%n", i, actions.get(i).name());
        }
    }

    public static void main(String... args) {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
        Output output = new ConsoleOutput();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new PrintAllAction(output),
                new ExitAction());

        new TODOApp().init(validate, new SimpleMenu(), actions);

    }

}
