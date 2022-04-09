package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = -1;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {

        int colStart = column + 1;

        for (int rowIt = row; rowIt < data.length; rowIt++) {
            if (colStart < (data[rowIt].length)) {
                return true;
            }
            colStart = 0;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        column++;
        if (column >= data[row].length) {
            column = 0;
            do {
                row++;
            } while ((data[row].length <= 0));
        }

        Integer result = data[row][column];


        return result;
    }

}
