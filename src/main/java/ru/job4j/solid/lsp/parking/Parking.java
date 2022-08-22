package ru.job4j.solid.lsp.parking;

import java.util.Optional;

public interface Parking {
    boolean park(Car car);

    /**
     * @author Михалев Сергей
     * @version 1.0
     * @param idNumber Уникальный цифробуквенный идентификатор автомобиля
     * @return true если автомобиль находится на парковке, иначе false
     */
    Optional<Car> leave(String idNumber);

    boolean present(String idNumber);
}
