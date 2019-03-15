package com.dph.request.aggregator.lib.flow.dto;

public class AggregatorRequest<K> {

    private K key;

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }
}
