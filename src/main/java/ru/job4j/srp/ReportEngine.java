package ru.job4j.srp;

import ru.job4j.srp.printers.SimpleEmployeePrinter;
import ru.job4j.srp.printers.SimpleHeaderPrinter;

import java.text.SimpleDateFormat;

public class ReportEngine extends AbstractReportEngine {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");


    public ReportEngine(Store store) {
        super(store, new SimpleHeaderPrinter(), new SimpleEmployeePrinter(DATE_FORMAT));

    }

}
