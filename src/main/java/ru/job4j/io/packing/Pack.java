package ru.job4j.io.packing;

import ru.job4j.io.Search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Pack {

    private static List<Path> paths = new ArrayList<>(10);

    public static void main(String[] args) throws IOException {
        PackParams packParams = null;

        try {
            packParams = PackParamsValidator.validate(args);
        } catch (IllegalArgumentException e) {
            PackParamsValidator.printHintOnWrongKeys();
        }

        if (packParams != null) {
            final String ext = packParams.getExcludeExtension();
            Search.search(Path.of(packParams.getSourceDirectory()), p -> !p.toFile()
                    .getName().endsWith(ext)).forEach(paths::add);
            System.out.println(paths);
            new Zip().packFiles(paths,
                    Path.of(packParams.getTargetZIP()),
                    Path.of(packParams.getSourceDirectory()));
        }

    }


}
