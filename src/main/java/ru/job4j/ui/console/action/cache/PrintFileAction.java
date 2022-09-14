package ru.job4j.ui.console.action.cache;

import ru.job4j.cache.DirFileCache;
import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.input.Input;

public class PrintFileAction implements UserAction {
    private final DirFileCache cache;

    public PrintFileAction(DirFileCache cache) {
        this.cache = cache;
    }

    @Override
    public String name() {
        return "=== Print strings from File ===";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        String filePathStr = input.askStr("Please enter file name you want to print:");

        try {
            System.out.println(cache.get(filePathStr));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return true;
    }
}
