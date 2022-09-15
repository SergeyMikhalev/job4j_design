package ru.job4j.io.searcher.filters;

import java.nio.file.Path;

public interface SearchFilter {
    boolean filter(Path s);
}
