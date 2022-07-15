package ru.job4j.solid.srp;

import java.util.Calendar;

public class ReportViewer {

    public static void main(String... args) {

        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 10000);
        store.add(worker1);
        Report engine = new JSONReportEngine(store);
        System.out.println(engine.generate(em -> true));
    }
}
