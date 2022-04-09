package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = -1;

    public MatrixIt(int[][] data) {
        this.data = data;
        findNext();
    }

    @Override
    public boolean hasNext() {
        return ((row < data.length) && (column < data[row].length));
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = data[row][column];

        findNext();

        return result;
    }

    private void findNext() {
        column++;
        if (data.length < 1) {
            return;
        }
        if (column >= data[row].length) {
            column = 0;
            do {
                row++;
                if (row >= data.length) {
                    return;
                }
            } while ((data[row].length <= 0));
        }
    }
}
