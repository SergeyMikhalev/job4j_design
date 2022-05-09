package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class SimpleMapTest {

    @Test
    public void putAndThenGetOK() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        Assert.assertTrue(map.put(10, 20));
        Assert.assertEquals(map.get(10), Integer.valueOf(20));
    }

    @Test
    public void whenDoublePutWithSameKey() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        Assert.assertTrue(map.put(10, 20));
        Assert.assertFalse(map.put(10, 30));
    }

    @Test
    public void whenGetFromEmpty() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        Assert.assertNull(map.get(10));

    }

    @Test
    public void whenRemoveEmpty() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        Assert.assertFalse(map.remove(10));
    }

    @Test
    public void whenRemoveOk() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(10, 10);
        Assert.assertTrue(map.remove(10));
    }

    @Test
    public void whenNeedToExpand() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();

        map.put(1, 110);
        map.put(2, 120);
        map.put(3, 130);
        map.put(4, 140);
        map.put(5, 150);
        map.put(6, 160);
        map.put(7, 170);
        map.put(8, 180);
        map.put(9, 190);

        Assert.assertEquals(map.get(1), Integer.valueOf(110));
        Assert.assertEquals(map.get(2), Integer.valueOf(120));
        Assert.assertEquals(map.get(3), Integer.valueOf(130));
        Assert.assertEquals(map.get(4), Integer.valueOf(140));
        Assert.assertEquals(map.get(5), Integer.valueOf(150));
        Assert.assertEquals(map.get(6), Integer.valueOf(160));
        Assert.assertEquals(map.get(7), Integer.valueOf(170));
        Assert.assertEquals(map.get(8), Integer.valueOf(180));
        Assert.assertEquals(map.get(9), Integer.valueOf(190));
    }

    @Test
    public void whenOneEntryWithIterator() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 10);
        Iterator<Integer> it = map.iterator();

        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(it.next(), Integer.valueOf(1));
    }

    @Test
    public void whenAccessTwoItemsViaIterator() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 10);
        map.put(2, 10);
        Iterator<Integer> it = map.iterator();

        Assert.assertTrue(it.hasNext());
        it.next();
        Assert.assertTrue(it.hasNext());
    }

    @Test
    public void whenAccessTwoItemsViaIteratorButThereIsOnlyOne() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 10);
        Iterator<Integer> it = map.iterator();

        Assert.assertTrue(it.hasNext());
        it.next();
        Assert.assertFalse(it.hasNext());
    }


}
