package ru.job4j.solid.isp.error;

public interface ParkingLot {
    void parkCar();  // Decrease empty spot count by 1

    void unparkCar(); // Increase empty spots by 1

    void getCapacity();  // Returns car capacity

    /* Последние два метода окажутся лишними, если мы предположим, что бывают ещё
     * и бесплатные парковки. Их стоит отделить в другой интерфейс.
     */
    double calculateFee(Car car); // Returns the price based on number of hours

    void doPayment(Car car);
}

class Car {
}
