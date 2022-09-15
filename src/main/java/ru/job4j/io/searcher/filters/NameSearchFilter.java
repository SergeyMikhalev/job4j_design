package ru.job4j.io.searcher.filters;

import java.nio.file.Path;

public class NameSearchFilter implements SearchFilter {
    private final String filename;

    public NameSearchFilter(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean filter(Path s) {
        return s.toFile().getName().equals(filename);
    }
}
