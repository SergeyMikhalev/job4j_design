package ru.job4j.solid.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONReportEngine extends AbstractReportEngine {

    private GsonBuilder gsonBuilder;
    private Gson gson;

    public JSONReportEngine(Store store) {
        super(store);
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    @Override
    protected String printBeforeEmployees() {
        return "";
    }

    @Override
    protected String printEmployee(Employee employee) {

        return gson.toJson(employee) + System.lineSeparator();
    }
}
