package ru.job4j.io.searcher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiPredicate;

public class SearchParams {
    private final String searchDir;
    private final String searchMask;
    private final  SearchType searchType;
    private final String resultFile;


    public SearchParams(String searchDir, String searchMask, SearchType searchType, String resultFile) {
        this.searchDir = searchDir;
        this.searchMask = searchMask;
        this.searchType = searchType;
        this.resultFile = resultFile;
    }

    public String getSearchDir() {
        return searchDir;
    }

    public String getSearchMask() {
        return searchMask;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public String getResultFile() {
        return resultFile;
    }

    @Override
    public String toString() {
        return "SearchParams{"
                + "searchDir='" + searchDir + '\''
                + ", searchMask='" + searchMask + '\''
                + ", searchType=" + searchType
                + ", resultFile='" + resultFile + '\''
                + '}';
    }

    enum SearchType {
        MASK,
        FULL_NAME,
        REGEXP
    }
}
