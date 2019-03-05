package com.dph.request.aggregator.lib.flow.data;

import java.util.Map;

public class SharedData<K, V> {

    private Map<K, V> data;

    public SharedData(Map<K, V> transactions) {
        this.data = transactions;
    }

    public void startHandshake(K key, V value) {
        data.put(key, value);
    }

    public V endHandshake(K key) {
        return data.get(key);
    }
}
