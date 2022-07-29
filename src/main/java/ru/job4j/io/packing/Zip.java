package ru.job4j.io.packing;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {


    public void packFiles(List<Path> sources, Path target, Path root) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path source : sources) {

                System.out.println(source.toFile().getPath());
                System.out.println(root.toFile().getPath());
                System.out.println(root.relativize(source).toFile().getPath());
                zip.putNextEntry(new ZipEntry(root.relativize(source).toFile().getPath()));

                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(Path source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml").toPath(),
                new File("./pom.zip").toPath()
        );
    }
}
