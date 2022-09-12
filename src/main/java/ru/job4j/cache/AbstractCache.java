package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {

    }

    public V get(K key) {
        V result = null;
        SoftReference<V> refResult = cache.get(key);
        if (!Objects.isNull(refResult)) {
            result = refResult.get();
        }
        if (Objects.isNull(refResult) || Objects.isNull(result)) {
            result = load(key);
            refResult = new SoftReference<>(result);
            cache.put(key, refResult);
        }
        return result;
    }

    protected abstract V load(K key);

}
