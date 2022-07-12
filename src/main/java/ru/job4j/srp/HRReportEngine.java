package ru.job4j.srp;

import java.util.List;

public class HRReportEngine extends AbstractReportEngine {

    public HRReportEngine(Store store) {
        super(store);
    }

    @Override
    protected void preprocessData(List<Employee> employees) {
        employees.sort((Employee e1, Employee e2) -> {
            return (int) (e2.getSalary() - e1.getSalary());
        });
    }

    @Override
    protected String printBeforeEmployees() {
        return "Name; Salary;" + System.lineSeparator();
    }

    @Override
    protected String printEmployee(Employee employee) {
        StringBuilder text = new StringBuilder();

        text.append(employee.getName()).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator());

        return text.toString();
    }
}
