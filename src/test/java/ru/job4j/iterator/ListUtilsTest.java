package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void removeLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeIf(input, v -> v == 2);
        assertThat(input, is(Arrays.asList(0, 1)));
    }

    @Test
    public void removeFirst() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeIf(input, v -> v == 0);
        assertThat(input, is(Arrays.asList(1, 2)));
    }

    @Test
    public void removeEven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.removeIf(input, v -> v % 2 == 0);
        assertThat(input, is(Arrays.asList(1, 3, 5)));
    }

    @Test
    public void replaceEven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6));
        ListUtils.replaceIf(input, v -> v % 2 == 0, 0);
        assertThat(input, is(Arrays.asList(0, 3, 0, 5, 0)));
    }

    @Test
    public void replaceAllTest() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> remove = new ArrayList<>(Arrays.asList(2, 5, 7));
        ListUtils.removeAll(input, remove);
        assertThat(input, is(Arrays.asList(1, 3, 4, 6)));
    }

}
