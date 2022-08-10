package ru.job4j.solid.lsp.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SimpleParking implements Parking {

    private static final int PASSENGER_PARKING_PLACE_SIZE = 1;
    private static final int TRUCK_PARKING_PLACE_SIZE = 1;

    private int passengerPlacesFree;
    private int trackPlacesFree;

    private final Map<Integer, Car> pass = new HashMap<>();
    private final Map<Integer, Car> trucks = new HashMap<>();

    public SimpleParking(int passengerPlaces, int trackPlaces) {
        passengerPlacesFree = passengerPlaces;
        trackPlacesFree = trackPlaces;
    }

    @Override
    public boolean park(Car car) {
        boolean result = false;
        if (!present(car.getId())) {
            if (car.getSize() > ParkingRules.PASSENGER_CAR_SIZE) {
                result = parkTruck(car);
            } else {
                result = parkPass(car);
            }
        }
        return result;
    }

    @Override
    public Optional<Car> leave(int id) {
        Optional<Car> result = Optional.empty();
        if (trucks.containsKey(id)) {
            result = Optional.of(trucks.get(id));
            trackPlacesFree += result.get().getSize();
        } else {
            if (pass.containsKey(id)) {
                result = Optional.of(pass.get(id));
                passengerPlacesFree += ParkingRules.PASSENGER_CAR_SIZE;
            }
        }
        return result;
    }

    @Override
    public boolean present(int id) {
        return (pass.containsKey(id) || trucks.containsKey(id));
    }

    private boolean parkTruck(Car car) {
        boolean result = false;
        if (trackPlacesFree >= TRUCK_PARKING_PLACE_SIZE) {
            trackPlacesFree--;
            trucks.put(car.getId(), car);
            result = true;
        } else if (passengerPlacesFree >= car.getSize()) {
            passengerPlacesFree -= car.getSize();
            pass.put(car.getId(), car);
            result = true;
        }
        return result;
    }

    private boolean parkPass(Car car) {
        boolean result = false;
        if (passengerPlacesFree >= PASSENGER_PARKING_PLACE_SIZE) {
            passengerPlacesFree--;
            pass.put(car.getId(), car);
            result = true;
        }
        return result;
    }
}
