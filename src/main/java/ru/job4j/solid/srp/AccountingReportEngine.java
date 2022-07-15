package ru.job4j.solid.srp;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class AccountingReportEngine extends AbstractReportEngine {

    public static final SimpleDateFormat ACCOUNTING_DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public static final DecimalFormat ACCOUNTING_SALARY_FORMAT = new DecimalFormat("###,###,###.00");

    public AccountingReportEngine(Store store) {
        super(store);
    }

    @Override
    protected String printEmployee(Employee employee) {
        StringBuilder text = new StringBuilder();

        text.append(employee.getName()).append(";")
                .append(ACCOUNTING_DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                .append(ACCOUNTING_DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                .append(ACCOUNTING_SALARY_FORMAT.format(employee.getSalary())).append(";")
                .append(System.lineSeparator());

        return text.toString();
    }
}
