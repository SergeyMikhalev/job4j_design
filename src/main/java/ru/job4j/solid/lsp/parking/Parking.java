package ru.job4j.solid.lsp.parking;

import java.util.Optional;

public interface Parking {
    boolean park(Car car);

    Optional<Car> leave(String idNumber);

    boolean present(String idNumber);
}
