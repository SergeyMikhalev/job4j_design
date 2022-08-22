package ru.job4j.ui.console.action.sort;

import ru.job4j.gc.prof.Data;
import ru.job4j.gc.prof.Sort;
import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.input.Input;

public class SortAction implements UserAction {

    private final String sortingName;
    private final Sort sort;
    private final Data data;

    public SortAction(String sortingName, Sort sort, Data data) {
        this.sortingName = sortingName;
        this.sort = sort;
        this.data = data;
    }

    @Override
    public String name() {
        return "=== Sorting : " + sortingName + " ===";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        sort.sort(data);
        return true;
    }
}
