package ru.job4j.io.searcher;

import ru.job4j.io.Search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class SearchMain {
    public static void main(String... args) {

        try {
            SearchParams params = SearchParamsValidator.validate(args);
            System.out.println(params);
            List<Path> paths = Search.search(params.getSearchDir(), params.getFilter()::filter);
            List<String> pathStrings = paths.stream().map(path ->
                    path.toString()
            ).collect(Collectors.toList());
            System.out.println(pathStrings);
            Files.write(params.getResultFile(), pathStrings);
        } catch (IllegalArgumentException e) {
            System.out.println(SearchParamsValidator.getHint());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
