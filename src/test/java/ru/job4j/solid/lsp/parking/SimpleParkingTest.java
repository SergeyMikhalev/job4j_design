package ru.job4j.solid.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SimpleParkingTest {
    Parking parking = new SimpleParking(2, 1);


    @Test
    public void whenOnlyPassenger() {

        Assert.assertTrue(parking.park(new PassengerCar(0)));
        Assert.assertTrue(parking.park(new PassengerCar(1)));
        Assert.assertFalse(parking.park(new PassengerCar(2)));
        Assert.assertTrue(parking.leave(2).isEmpty());
        Assert.assertTrue(parking.present(0));
        Assert.assertTrue(parking.present(1));
        Assert.assertFalse(parking.present(2));
    }

    @Test
    public void whenBigCargoes() {
        Assert.assertTrue(parking.park(new Truck(0, 1000)));
        Assert.assertTrue(parking.park(new Truck(1, 2)));
        parking.leave(1);
        Assert.assertFalse(parking.park(new Truck(2, 3)));
        Assert.assertFalse(parking.present(2));
    }

    @Test
    public void whenTwoAutoWithSameId() {
        Assert.assertTrue(parking.park(new PassengerCar(0)));
        Assert.assertFalse(parking.park(new PassengerCar(0)));
    }

    @Test
    public void whenCargoesAndPassenger() {
        Assert.assertTrue(parking.park(new Truck(0, 1000)));
        Assert.assertTrue(parking.park(new Truck(1, 2)));
        parking.leave(1);
        Assert.assertTrue(parking.park(new PassengerCar(7)));
        Assert.assertFalse(parking.park(new Truck(2, 2)));
        Assert.assertFalse(parking.present(2));
    }
}
