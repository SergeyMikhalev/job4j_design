package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

/**
 * Простая реализация ArrayList
 */

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        checkSizeAndGrow();
        modCount++;
        container[size++] = value;

    }

    @Override
    public T set(int index, T newValue) {
        T result = get(index);
        container[index] = newValue;
        return result;
    }

    @Override
    public T remove(int index) {
        T result = get(index);
        modCount++;
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                size - index - 1
        );
        container[size - 1] = null;
        size--;
        return result;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return this.size;
    }


    private void checkSizeAndGrow() {
        if (size >= container.length) {
            container = Arrays.copyOf(container, (container.length < 0 ? 10 : container.length * 2));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int expectedModCount = modCount;
            private int pointer = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return pointer < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[pointer++];
            }

        };
    }
}
