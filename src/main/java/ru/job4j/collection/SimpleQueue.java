package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        try {
            while (true) {
                out.push(in.pop());
            }

        } catch (NoSuchElementException e) {
        } finally {
            return out.pop();
        }

    }

    public void push(T value) {
        try {
            while (true) {
                in.push(out.pop());
            }

        } catch (NoSuchElementException e) {
        } finally {
            in.push(value);
        }


    }
}
