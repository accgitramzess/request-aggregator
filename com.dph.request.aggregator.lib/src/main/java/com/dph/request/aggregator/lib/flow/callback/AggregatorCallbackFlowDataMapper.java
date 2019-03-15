package com.dph.request.aggregator.lib.flow.callback;

public interface AggregatorCallbackFlowDataMapper<K, V> {

    K process(V value);
}
