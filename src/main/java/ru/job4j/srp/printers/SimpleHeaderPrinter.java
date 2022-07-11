package ru.job4j.srp.printers;

public class SimpleHeaderPrinter implements ReportHeaderPrinter {
    @Override
    public String printHeader() {
        return "Name; Hired; Fired; Salary;" + System.lineSeparator();
    }
}
