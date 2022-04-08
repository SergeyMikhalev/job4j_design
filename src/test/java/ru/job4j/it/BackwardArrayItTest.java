package ru.job4j.it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BackwardArrayItTest {


    @Test
    public void whenMultiCallHasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());

    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertEquals(Long.valueOf(it.next()), Long.valueOf(3));
        assertEquals(Long.valueOf(it.next()), Long.valueOf(2));
        assertEquals(Long.valueOf(it.next()), Long.valueOf(1));

    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{}
        );
        it.next();
    }
}
