package ru.job4j.io.searcher.filters;

import java.nio.file.Path;

public class RegExpSearchFilter implements SearchFilter {
    private final String regex;

    public RegExpSearchFilter(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean filter(Path s) {
        System.out.println(regex);
        return s.toFile().getName().matches(regex);
    }
}
