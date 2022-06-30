package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return comp(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return comp(value, comparator.reversed());
    }

    private <T> T comp(List<T> value, Comparator<T> comparator) {
        if (value == null || comparator == null || value.size() < 1) {
            throw new IllegalArgumentException();
        }
        T result = value.get(0);
        for (T element : value) {
            result = (comparator.compare(result, element) > 0) ? result : element;
        }
        return result;
    }
}
