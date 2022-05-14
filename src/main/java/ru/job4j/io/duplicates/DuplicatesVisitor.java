package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, ArrayList<String>> files = new HashMap<>();

    public void printDuplicates() {
        files.forEach(new BiConsumer<FileProperty, ArrayList<String>>() {
            @Override
            public void accept(FileProperty fileProperty, ArrayList<String> strings) {
                if (strings.size() > 1) {
                    System.out.println("File " + fileProperty.getName() + " with size " + fileProperty.getSize() + " has duplicates");
                    System.out.println("Locations are ------------------");
                    strings.forEach(System.out::println);
                    System.out.println("------- end of locations -------");
                }
            }
        });
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty prop = new FileProperty(attrs.size(), file.getFileName().toString());

        if (files.containsKey(prop)) {
            files.get(prop).add(file.toAbsolutePath().toString());
        } else {
            ArrayList<String> ways = new ArrayList<>();
            ways.add(file.toAbsolutePath().toString());
            files.put(prop, ways);
        }
        return super.visitFile(file, attrs);
    }
}