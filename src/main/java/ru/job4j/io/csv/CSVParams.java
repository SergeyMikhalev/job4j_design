package ru.job4j.io.csv;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class CSVParams {

    private final Path source;
    private final String delimiter;
    private final List<String> columns;
    private final boolean printToConsole;
    private final Path target;

    public CSVParams(Path source, String delimiter, List<String> columns, boolean printToConsole, Path target) {
        this.source = source;
        this.delimiter = delimiter;
        this.columns = columns;
        this.printToConsole = printToConsole;
        this.target = target;
    }

    public Path getSource() {
        return source;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public List<String> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    public boolean isPrintToConsole() {
        return printToConsole;
    }

    public Path getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "CSVParams{"
                + "source=" + source
                + ", delimiter='" + delimiter + '\''
                + ", columns=" + columns
                + ", printToConsole=" + printToConsole
                + ", target=" + target
                + '}';
    }
}
