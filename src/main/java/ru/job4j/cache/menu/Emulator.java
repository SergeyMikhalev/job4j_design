package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;
import ru.job4j.gc.prof.TestSortingApp;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.action.cache.PrintFileAction;
import ru.job4j.ui.console.action.cache.SetCacheDirAction;
import ru.job4j.ui.console.action.sort.ExitAction;
import ru.job4j.ui.console.input.ConsoleInput;
import ru.job4j.ui.console.input.Input;
import ru.job4j.ui.console.input.ValidateInput;
import ru.job4j.ui.console.output.ConsoleOutput;
import ru.job4j.ui.console.output.Output;

import java.util.List;

public class Emulator {

    private static final String DEFAULT_DIR_PATH = "C:\\Temp\\";

    public void init(Input input, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Enter select: ");
            UserAction action = actions.get(select);
            run = action.execute(input, null);
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

        DirFileCache cache = new DirFileCache(DEFAULT_DIR_PATH);
        System.out.println("Default cache dir path ->" + DEFAULT_DIR_PATH);


        System.out.println();

        List<UserAction> actions = List.of(
                new SetCacheDirAction(cache),
                new PrintFileAction(cache),
                new ExitAction()
        );

        new TestSortingApp().init(validate, actions);

    }

}
