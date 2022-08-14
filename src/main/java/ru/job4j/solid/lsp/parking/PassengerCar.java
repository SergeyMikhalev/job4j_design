package ru.job4j.solid.lsp.parking;

public class PassengerCar implements Car {
    private final String idNumber;

    public PassengerCar(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String getIdNumber() {
        return idNumber;
    }

    @Override
    public int getSize() {
        return ParkingRules.PASSENGER_CAR_SIZE;
    }
}
