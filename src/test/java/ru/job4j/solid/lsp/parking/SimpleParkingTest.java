package ru.job4j.solid.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SimpleParkingTest {
    Parking parking = new ParkingMock(2, 1);


    @Test
    public void whenOnlyPassenger() {

        Assert.assertTrue(parking.park(new CarMock(0, 1)));
        Assert.assertTrue(parking.park(new CarMock(1, 1)));
        Assert.assertFalse(parking.park(new CarMock(2, 1)));

        Assert.assertTrue(parking.leave(2).isEmpty());

        Assert.assertTrue(parking.present(0));
        Assert.assertTrue(parking.present(1));
        Assert.assertFalse(parking.present(2));
    }

    @Test
    public void whenBigCargoes() {
        Assert.assertTrue(parking.park(new CarMock(0, 1000)));
        Assert.assertTrue(parking.park(new CarMock(1, 2)));

        parking.leave(1);

        Assert.assertFalse(parking.park(new CarMock(2, 3)));
        Assert.assertFalse(parking.present(2));
    }

    @Test
    public void whenTwoAutoWithSameId() {
        Assert.assertTrue(parking.park(new CarMock(0, 1)));
        Assert.assertFalse(parking.park(new CarMock(0, 1)));
    }

    @Test
    public void whenCargoesAndPassenger() {
        Assert.assertTrue(parking.park(new CarMock(0, 1000)));
        Assert.assertTrue(parking.park(new CarMock(1, 2)));

        parking.leave(1);

        Assert.assertTrue(parking.park(new CarMock(7, 1)));
        Assert.assertFalse(parking.park(new CarMock(2, 2)));
        Assert.assertFalse(parking.present(2));
    }
}
