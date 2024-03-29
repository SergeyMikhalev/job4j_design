package ru.job4j.io.csv;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ru.job4j.io.ArgsName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;

class CSVReaderTest {

    @Test
    void whenFilterTwoColumns(@TempDir Path folder) throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = folder.resolve("source.csv").toFile();
        File target = folder.resolve("target.csv").toFile();
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;",
                "-out=" + target.getAbsolutePath(), "-filter=name,education"});
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "name;education",
                "Tom;Bachelor",
                "Jack;Undergraduate",
                "William;Secondary special"
        ).concat(System.lineSeparator());
        CSVReader.handle(argsName);
        assertEquals(Files.readString(target.toPath()), expected);
    }

    @Test
    void whenFilterThreeColumns(@TempDir Path folder) throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = folder.resolve("source.csv").toFile();
        File target = folder.resolve("target.csv").toFile();
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;",
                "-out=" + target.getAbsolutePath(), "-filter=education,age,last_name"
        });
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "education;age;last_name",
                "Bachelor;20;Smith",
                "Undergraduate;25;Johnson",
                "Secondary special;30;Brown"
        ).concat(System.lineSeparator());
        CSVReader.handle(argsName);
        Assert.assertEquals(Files.readString(target.toPath()), expected);
    }
}
