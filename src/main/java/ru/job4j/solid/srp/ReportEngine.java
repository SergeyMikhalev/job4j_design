package ru.job4j.solid.srp;


import java.text.SimpleDateFormat;
import java.util.List;

public class ReportEngine extends AbstractReportEngine {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    public ReportEngine(Store store) {
        super(store);
    }

    @Override
    protected void preprocessData(List<Employee> employees) {
    }

    @Override
    protected String printEmployee(Employee employee) {
        StringBuilder text = new StringBuilder();

        text.append(employee.getName()).append(";")
                .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator());

        return text.toString();
    }
}
