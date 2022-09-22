package ru.job4j.io.searcher;

import ru.job4j.io.searcher.filters.SearchFilter;

import java.nio.file.Path;

public class SearchParams {
    private final Path searchDir;
    private final Path resultFile;
    private final SearchFilter filter;

    public SearchParams(Path searchDir, Path resultFile, SearchFilter filter) {
        this.searchDir = searchDir;
        this.resultFile = resultFile;
        this.filter = filter;
    }

    public Path getSearchDir() {
        return searchDir;
    }

    public Path getResultFile() {
        return resultFile;
    }

    public SearchFilter getFilter() {
        return filter;
    }

    @Override
    public String toString() {
        return "SearchParams{"
                + "searchDir=" + searchDir
                + ", resultFile=" + resultFile
                + ", filter=" + filter
                + '}';
    }
}
