package ru.job4j.solid.lsp.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SimpleParking implements Parking {

    private int passengerPlacesFree;
    private int trackPlacesFree;

    private final Map<String, Car> pass = new HashMap<>();
    private final Map<String, Car> trucks = new HashMap<>();

    public SimpleParking(int passengerPlaces, int trackPlaces) {
        passengerPlacesFree = passengerPlaces;
        trackPlacesFree = trackPlaces;
    }

    @Override
    public boolean park(Car car) {
        boolean result = false;
        if (!present(car.getIdNumber())) {
            if (car.getSize() > ParkingRules.PASSENGER_CAR_SIZE) {
                result = parkTruck(car);
            } else {
                result = parkPass(car);
            }
        }
        return result;
    }

    @Override
    public Optional<Car> leave(String idNumber) {
        Optional<Car> result = Optional.empty();
        if (trucks.containsKey(idNumber)) {
            result = Optional.of(trucks.get(idNumber));
            trackPlacesFree += result.get().getSize();
        } else {
            if (pass.containsKey(idNumber)) {
                result = Optional.of(pass.get(idNumber));
                passengerPlacesFree += ParkingRules.PASSENGER_CAR_SIZE;
            }
        }
        return result;
    }

    /**
     * @author Михалев Сергей
     * @version 1.0
     * @param idNumber Уникальный цифробуквенный идентификатор автомобиля
     * @return true если автомобиль находится на парковке, иначе false
    */
    @Override
    public boolean present(String idNumber) {
        return (pass.containsKey(idNumber) || trucks.containsKey(idNumber));
    }

    private boolean parkTruck(Car car) {
        boolean result = false;
        if (trackPlacesFree >= ParkingRules.PASSENGER_CAR_SIZE) {
            trackPlacesFree--;
            trucks.put(car.getIdNumber(), car);
            result = true;
        } else if (passengerPlacesFree >= car.getSize()) {
            passengerPlacesFree -= car.getSize();
            pass.put(car.getIdNumber(), car);
            result = true;
        }
        return result;
    }

    private boolean parkPass(Car car) {
        boolean result = false;
        if (passengerPlacesFree >= ParkingRules.PASSENGER_CAR_SIZE) {
            passengerPlacesFree--;
            pass.put(car.getIdNumber(), car);
            result = true;
        }
        return result;
    }
}
