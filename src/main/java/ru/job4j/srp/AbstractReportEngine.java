package ru.job4j.srp;

import ru.job4j.srp.printers.ReportEmployeePrinter;
import ru.job4j.srp.printers.ReportHeaderPrinter;

import java.util.List;
import java.util.function.Predicate;

public class AbstractReportEngine implements Report {

    private Store store;
    private ReportHeaderPrinter headerPrinter;
    private ReportEmployeePrinter employeePrinter;

    public AbstractReportEngine(Store store, ReportHeaderPrinter headerPrinter, ReportEmployeePrinter employeePrinter) {
        this.store = store;
        this.headerPrinter = headerPrinter;
        this.employeePrinter = employeePrinter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(headerPrinter.printHeader());
        for (Employee employee : getData(filter)) {
            text.append(employeePrinter.print(employee));
        }
        return text.toString();
    }

    private List<Employee> getData(Predicate<Employee> filter) {
        return store.findBy(filter);
    }
}
