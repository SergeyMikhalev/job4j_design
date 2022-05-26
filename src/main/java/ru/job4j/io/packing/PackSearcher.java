package ru.job4j.io.packing;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;

public class PackSearcher extends SimpleFileVisitor {

    private java.util.List<File> files = new LinkedList<>();
    private String extension;

    public PackSearcher(String extension) {
        this.extension = extension;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {

        return super.visitFile(file, attrs);
    }
}
