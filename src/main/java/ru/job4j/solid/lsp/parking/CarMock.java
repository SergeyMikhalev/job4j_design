package ru.job4j.solid.lsp.parking;

public class CarMock implements Car {

    public CarMock() {
    }

    public CarMock(int id, int size) {
    }


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
