package ru.job4j.solid.isp.error;

public interface ParkingLot {
    void parkCar();

    void unparkCar();

    void getCapacity();

    /* Последние два метода окажутся лишними, если мы предположим, что бывают ещё
     * и бесплатные парковки. Их стоит отделить в другой интерфейс.
     */
    double calculateFee(Car car);

    void doPayment(Car car);
}

class Car {
}
