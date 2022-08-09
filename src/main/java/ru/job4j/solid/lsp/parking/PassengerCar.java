package ru.job4j.solid.lsp.parking;

public class PassengerCar implements Car {
    private final int id;

    public PassengerCar(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getSize() {
        return ParkingRules.PASSENGER_CAR_SIZE;
    }
}
