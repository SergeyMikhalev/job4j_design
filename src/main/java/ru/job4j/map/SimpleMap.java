package ru.job4j.map;

import java.util.Iterator;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    private int hash(int hashCode) {
        return hashCode;                // TODO: 04.05.2022 Заменить на нормальный вариант
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {

    }

    @Override
    public V get(K key) {
        return table[indexFor(hash(key.hashCode()))].value;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        boolean rsl = table[index] == null;
        table[index] = null;
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
