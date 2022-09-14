package ru.job4j.ui.console.action.cache;

import ru.job4j.cache.DirFileCache;
import ru.job4j.solid.isp.menu.Menu;
import ru.job4j.ui.console.action.UserAction;
import ru.job4j.ui.console.input.Input;

import java.nio.file.Path;

public class SetCacheDirAction implements UserAction {


    private final DirFileCache cache;

    public SetCacheDirAction(DirFileCache cache) {
        this.cache = cache;
    }

    @Override
    public String name() {
        return "=== Setting cacheable directory ===";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        String cachePathStr = input.askStr("Please enter a path to cacheable directory:");

        if (Path.of(cachePathStr).toFile().isDirectory()) {
            cache.setCachingDir(cachePathStr);
            System.out.println("New cacheable directory path succesfuly set.");
        } else {
            System.out.println("Wrong directory path");
        }

        return true;
    }
}
