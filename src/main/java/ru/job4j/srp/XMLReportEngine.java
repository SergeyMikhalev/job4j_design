package ru.job4j.srp;

import ru.job4j.serialization.xml.PrinterHelper;

import javax.xml.bind.JAXBException;

public class XMLReportEngine extends AbstractReportEngine {


    public XMLReportEngine(Store store) {
        super(store);
    }

    @Override
    protected String printBeforeEmployees() {
        return "";
    }

    @Override
    protected String printEmployee(Employee employee) {
        String result = "";
        try {
            result = PrinterHelper.doString(employee) + System.lineSeparator();
        } catch (JAXBException e) {
            e.printStackTrace();
            result = "-error while saving-" + System.lineSeparator();
        }
        return result;
    }
}
