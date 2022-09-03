package ru.job4j.io.searcher;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.function.Predicate;

public class SearchFilter implements Predicate<String> {
    private final SearchParams.SearchType searchType;
    private final String criteria;

    public SearchFilter(SearchParams.SearchType searchType, String criteria) {
        this.searchType = searchType;
        this.criteria = criteria;
    }

    @Override
    public boolean test(String s) {
        boolean result = false;


        return result;
    }

    private boolean maskSearch(String file) {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(criteria);
        return false;
    }
}
