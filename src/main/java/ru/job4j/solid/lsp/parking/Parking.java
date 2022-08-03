package ru.job4j.solid.lsp.parking;

import java.util.Optional;

public interface Parking {
    boolean park(Car car);

    Optional<Car> leave(int id);

    boolean present(int id);
}
