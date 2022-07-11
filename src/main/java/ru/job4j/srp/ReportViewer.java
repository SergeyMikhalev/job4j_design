package ru.job4j.srp;

import java.util.Calendar;

public class ReportViewer {

    public static void main(String... args) {

        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        System.out.println(engine.generate(em -> true));
    }
}
