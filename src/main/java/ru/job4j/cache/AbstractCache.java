package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));

    }

    public V get(K key) {
        V result = null;
        System.out.println("Loading from cache...");
        SoftReference<V> refResult = cache.getOrDefault(key, new SoftReference<>(null));
        result = refResult.get();

        if (Objects.isNull(result)) {
            System.out.println("Object not found, loading from file system...");
            result = load(key);
            refResult = new SoftReference<>(result);
            cache.put(key, refResult);
        }
        return result;
    }

    protected abstract V load(K key);

}
