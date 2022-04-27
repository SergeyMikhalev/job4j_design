package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {

        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.pop();

    }

    public void push(T value) {
        while (!out.isEmpty()) {
            in.push(out.pop());
        }

        in.push(value);

    }
}
