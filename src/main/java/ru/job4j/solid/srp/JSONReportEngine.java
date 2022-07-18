package ru.job4j.solid.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class JSONReportEngine implements Report {

    private Store store;
    private GsonBuilder gsonBuilder;
    private Gson gson;

    public JSONReportEngine(Store store) {
        this.store = store;
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
