package ru.job4j.solid.lsp.parking;

import java.util.Optional;

public class ParkingMock implements Parking {
    public ParkingMock(int passengerPlaces, int cargoPlaces) {
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public Optional<Car> leave(int id) {
        return Optional.empty();
    }

    @Override
    public boolean present(int id) {
        return false;
    }
}
