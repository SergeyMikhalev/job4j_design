package ru.job4j.io.searcher.filters;

import java.nio.file.Path;

public class MaskSearchFilter implements SearchFilter {
    private final String regex;

    public MaskSearchFilter(String mask) {
        this.regex = "^"
                +
                mask
                        .replace(".", "[.]")
                        .replace("*", ".*")
                        .replace("?", ".") +
                "$";
    }

    @Override
    public boolean filter(Path s) {
        return s.toFile().getName().matches(regex);
    }
}
