package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractReportEngine implements Report {

    protected Store store;

    public AbstractReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {

        List<Employee> employees = store.findBy(filter);
        preprocessData(employees);

        StringBuilder text = new StringBuilder();
        text.append(printBeforeEmployees());

        for (Employee employee : employees) {
            text.append(printEmployee(employee));
        }

        text.append(printAfterEmployees());
        return text.toString();
    }

    protected void preprocessData(List<Employee> employees) {
    }

    protected String printBeforeEmployees() {
        return "Name; Hired; Fired; Salary;" + System.lineSeparator();
    }

    protected String printEmployee(Employee employee) {
        return employee.toString();
    }

    protected String printAfterEmployees() {
        return "";
    }

}
