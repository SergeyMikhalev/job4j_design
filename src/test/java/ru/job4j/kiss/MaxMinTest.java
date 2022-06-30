package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMinTest {
    @Test(expected = IllegalArgumentException.class)
    public void WhenEmptyList() {
        new MaxMin().max(new ArrayList<Integer>(), Comparator.naturalOrder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenListIsNull() {
        List<Integer> list = null;
        new MaxMin().max(list, Comparator.naturalOrder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenComparatorIsNull() {
        new MaxMin().max(List.of(1, 2, 3, 4), null);
    }

    @Test
    public void WhenMaxOfOne() {
        Assert.assertEquals((long) (new MaxMin().max(List.of(77), Comparator.naturalOrder())), 77L);
    }

    @Test
    public void WhenMaxOfMany() {
        Assert.assertEquals((long) (new MaxMin().max(List.of(0, 12, 6, 9, 77), Comparator.naturalOrder())), 77L);
    }

    @Test
    public void WhenMinOfOne() {
        Assert.assertEquals((long) (new MaxMin().min(List.of(77), Comparator.naturalOrder())), 77L);
    }

    @Test
    public void WhenMinOfMany() {
        Assert.assertEquals((long) (new MaxMin().min(List.of(88, 12, 6, 9, 77), Comparator.naturalOrder())), 6L);
    }
}
