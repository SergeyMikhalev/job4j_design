package ru.job4j.ui.console.action.cache;

import ru.job4j.cache.DirFileCache;
import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.input.Input;

public class LoadToCacheAction implements UserAction {

    private final DirFileCache cache;

    public LoadToCacheAction(DirFileCache cache) {
        this.cache = cache;
    }

    @Override
    public String name() {
        return "=== Load string file to cache ===";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        String filePathStr = input.
                askStr("Please enter a file you want to load from cacheable directory:");

        try {
            cache.load(filePathStr);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return true;
    }
}
