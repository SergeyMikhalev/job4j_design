package ru.job4j.solid.isp.error;

import java.util.Iterator;
import java.util.function.Consumer;

public interface IteratorExample extends Iterator {
    @Override
    default boolean hasNext() {
        return false;
    }

    @Override
    default Object next() {
        return null;
    }


    /* Собственно некоторые итераторы, которые я делал в рамках данного курса нарушают принцип
     * ISP используя вместо метода remove "заглушку". BackwardArrayIt например.
     */
    @Override
    default void remove() {
        Iterator.super.remove();
    }

    @Override
    default void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }
}
