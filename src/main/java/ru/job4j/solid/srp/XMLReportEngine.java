package ru.job4j.solid.srp;

import ru.job4j.serialization.xml.PrinterHelper;

import javax.xml.bind.JAXBException;
import java.util.function.Predicate;

public class XMLReportEngine implements Report {
    Store store;

    public XMLReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        EmployeesWrapper employees = new EmployeesWrapper(store.findBy(filter));
        String result;

        try {
            result = PrinterHelper.doString(employees);
        } catch (JAXBException e) {
            e.printStackTrace();
            result = "Error while serializing to XML";
        }

        return result;
    }
}
