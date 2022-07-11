package ru.job4j.srp.printers;

import ru.job4j.srp.Employee;

import java.text.SimpleDateFormat;

public class SimpleEmployeePrinter implements ReportEmployeePrinter {

    private final SimpleDateFormat dateFormat;

    public SimpleEmployeePrinter(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String print(Employee emp) {
        StringBuilder text = new StringBuilder();
        text.append(emp.getName()).append(";")
                .append(dateFormat.format(emp.getHired().getTime())).append(";")
                .append(dateFormat.format(emp.getFired().getTime())).append(";")
                .append(emp.getSalary()).append(";")
                .append(System.lineSeparator());
        return text.toString();
    }
}
