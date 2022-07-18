package ru.job4j.solid.srp;

import java.util.Calendar;

public class ReportViewer {

    public static void main(String... args) {

        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        now.set(2022, 1, 1, 1, 1, 1);
        Employee worker1 = new Employee("Ivan", now, now, 10000);
        store.add(worker1);
        Report engine = new XMLReportEngine(store);
        System.out.println(engine.generate(em -> true));
    }
}
