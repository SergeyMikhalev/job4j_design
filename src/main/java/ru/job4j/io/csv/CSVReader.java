package ru.job4j.io.csv;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    private static CSVParams params = null;
    private static PrintStream printer;

    public CSVReader() {
    }

    public static void handle(ArgsName args) {
        params = CSVValidator.validate(args);
        List<Integer> indexes = new ArrayList<>(params.getColumns().size());

        try (Scanner scanner = new Scanner(params.getSource())) {
            scanner.useDelimiter(System.lineSeparator());
            if (!scanner.hasNext()) {
                throw new RuntimeException("Неверный формат файла source.csv");
            }

            List<String> header = List.of(scanner.next().split(params.getDelimiter()));
            for (int i = 0; i < params.getColumns().size(); i++) {
                if (header.contains(params.getColumns().get(i))) {
                    indexes.add(header.indexOf(params.getColumns().get(i)));
                }
            }

            if (params.isPrintToConsole()) {
                printer = System.out;
                printAllData(scanner, indexes, header);
            } else {
                try (PrintStream outPrinter = new PrintStream(params.getTarget().toString())) {
                    printer = outPrinter;
                    printAllData(scanner, indexes, header);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAllData(Scanner scanner, List<Integer> indexes, List<String> header) {
        printCSVLine(header, indexes);
        while (scanner.hasNext()) {
            List<String> columns = List.of(scanner.next().split(params.getDelimiter()));
            printCSVLine(columns, indexes);
        }
    }

    private static void printCSVLine(List<String> columns, List<Integer> filter) {
        for (int i = 0; i < filter.size(); i++) {
            if (i > 0) {
                print(params.getDelimiter());
            }
            print(columns.get(filter.get(i)));
        }
        print(System.lineSeparator());

    }

    private static void print(String element) {
        printer.print(element);
    }


    public static void main(String... args) {
        CSVReader.handle(ArgsName.of(args));
    }
}
