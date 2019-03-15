package com.dph.request.aggregator.lib.configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dph.request.aggregator.lib.flow.main.AggregatorContext;

public class Aggregator<K, V> {

    private long timeout;

    private Map<K, AggregatorContext<V>> state;

    public Aggregator(long timeout) {
        this.timeout = timeout;
        state = new ConcurrentHashMap<>();
    }

    public V waitSignal(K key) throws AggregatorException {
        AggregatorContext<V> context = new AggregatorContext<>(timeout);
        state.put(key, context);

        V value = context.waitSignal();
        state.remove(key);

        if(value == null) {
            throw new AggregatorException();
        }

        return value;
    }

    public void releaseSignal(K key, V value) {
        try {
            AggregatorContext<V> context = state.get(key);
            context.releaseSignal(value);
        } catch(Exception ex) {
            throw new AggregatorException(ex);
        }
    }
}
