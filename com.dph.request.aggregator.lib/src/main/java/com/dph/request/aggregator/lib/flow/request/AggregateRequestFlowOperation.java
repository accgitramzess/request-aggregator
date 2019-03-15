package com.dph.request.aggregator.lib.flow.request;

public interface AggregateRequestFlowOperation<K, V> {

    void process(AggregateRequestFlowOperationContext<K, V> context);
}
