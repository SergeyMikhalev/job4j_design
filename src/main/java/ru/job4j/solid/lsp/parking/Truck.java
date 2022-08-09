package ru.job4j.solid.lsp.parking;

public class Truck implements Car {
    private final int id;
    private final int size;

    public Truck(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getSize() {
        return size;
    }
}
