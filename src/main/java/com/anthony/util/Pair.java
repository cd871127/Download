package com.anthony.util;

import java.util.Map;

/**
 * Created by Anthony on 2017/1/23.
 */
public class Pair<K, V> {
    public Pair() {
    }

    public Pair(K key, V value) {
        setKV(key, value);
    }

    private K key;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private V value;

    public Map<K, V> addToMap(Map<K, V> map) {
        map.put(key, value);
        return map;
    }

    public Pair<K, V> setKV(K key, V value) {
        setKey(key);
        setValue(value);
        return this;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        return getKey().equals(pair.getKey());
    }

    @Override
    public int hashCode() {
        return getKey().hashCode();
    }
}
