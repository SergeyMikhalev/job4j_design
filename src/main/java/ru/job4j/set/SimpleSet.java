package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        boolean valueDuplicate = contains(value);
        if (!valueDuplicate) {
            set.add(value);
        }
        return !valueDuplicate;
    }

    @Override
    public boolean contains(T value) {
        int i = 0;
        Iterator<T> dataIter = set.iterator();
        while (dataIter.hasNext() && !(Objects.equals(dataIter.next(), value))) {
            i++;
        }

        return i < set.size();
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
