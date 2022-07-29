package ru.job4j.io.packing;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class PackSearcher extends SimpleFileVisitor<Path> {

    private java.util.List<Path> files = new LinkedList<>();
    private String extension;
    private Path source;

    public PackSearcher(String extension) {
        this.extension = extension;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (!file.endsWith(extension)) {
            files.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getFiles() {
        return files;
    }
}
