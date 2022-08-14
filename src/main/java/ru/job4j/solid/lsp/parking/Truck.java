package ru.job4j.solid.lsp.parking;

public class Truck implements Car {
    private final String idNumber;
    private final int size;

    public Truck(String idNumber, int size) {
        this.idNumber = idNumber;
        this.size = size;
    }

    @Override
    public String getIdNumber() {
        return idNumber;
    }

    @Override
    public int getSize() {
        return size;
    }
}
