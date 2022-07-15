package ru.job4j.solid.srp;

import java.text.SimpleDateFormat;

public class PrgReportEngine extends AbstractReportEngine {

    public static final SimpleDateFormat PRG_DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    public PrgReportEngine(Store store) {
        super(store);
    }

    @Override
    protected String printBeforeEmployees() {
        StringBuilder text = new StringBuilder();
        text.append("<table>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator());
        return text.toString();
    }

    @Override
    protected String printEmployee(Employee employee) {
        StringBuilder text = new StringBuilder();

        text.append("<tr>")
                .append("<td>").append(employee.getName()).append("</td>")
                .append("<td>").append(PRG_DATE_FORMAT.format(employee.getHired().getTime())).append("</td>")
                .append("<td>").append(PRG_DATE_FORMAT.format(employee.getFired().getTime())).append("</td>")
                .append("<td>").append(employee.getSalary()).append("</td>")
                .append("<tr>")
                .append(System.lineSeparator());

        return text.toString();
    }

    @Override
    protected String printAfterEmployees() {
        return "</table>" + System.lineSeparator();
    }
}
