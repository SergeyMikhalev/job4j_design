package ru.job4j.solid.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SimpleParkingTest {
    Parking parking = new SimpleParking(2, 1);


    @Test
    public void whenOnlyPassenger() {

        Assert.assertTrue(parking.park(new PassengerCar("A0")));
        Assert.assertTrue(parking.park(new PassengerCar("A1")));
        Assert.assertFalse(parking.park(new PassengerCar("A2")));
        Assert.assertTrue(parking.leave("A2").isEmpty());
        Assert.assertTrue(parking.present("A0"));
        Assert.assertTrue(parking.present("A1"));
        Assert.assertFalse(parking.present("A2"));
    }

    @Test
    public void whenBigCargoes() {
        Assert.assertTrue(parking.park(new Truck("A0", 1000)));
        Assert.assertTrue(parking.park(new Truck("A1", 2)));
        parking.leave("A1");
        Assert.assertFalse(parking.park(new Truck("A2", 3)));
        Assert.assertFalse(parking.present("A2"));
    }

    @Test
    public void whenTwoAutoWithSameId() {
        Assert.assertTrue(parking.park(new PassengerCar("A0")));
        Assert.assertFalse(parking.park(new PassengerCar("A0")));
    }

    @Test
    public void whenCargoesAndPassenger() {
        Assert.assertTrue(parking.park(new Truck("A0", 1000)));
        Assert.assertTrue(parking.park(new Truck("A1", 2)));
        parking.leave("A1");
        Assert.assertTrue(parking.park(new PassengerCar("A7")));
        Assert.assertFalse(parking.park(new Truck("A2", 2)));
        Assert.assertFalse(parking.present("A2"));
    }
}
