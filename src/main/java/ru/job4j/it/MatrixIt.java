package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {

        if (row >= data.length) {
            return false;
        }

        if (column < data[row].length) {
            return true;
        }

        column = 0;
        while (++row < data.length) {
            if (data[row].length > 0) {
                return true;
            }
        }
        return false;

    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

}
