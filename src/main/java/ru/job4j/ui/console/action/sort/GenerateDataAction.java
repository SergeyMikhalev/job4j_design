package ru.job4j.ui.console.action.sort;

import ru.job4j.gc.prof.Data;
import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.input.Input;

public class GenerateDataAction implements UserAction {

    public static final int TEST_ARRAY_SIZE = 250_000;
    private final Data data;

    public GenerateDataAction(Data data) {
        this.data = data;
    }

    @Override
    public String name() {
        return "=== Regenerate Data Array for Sorting ====";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        data.insert(TEST_ARRAY_SIZE);
        return true;
    }
}
