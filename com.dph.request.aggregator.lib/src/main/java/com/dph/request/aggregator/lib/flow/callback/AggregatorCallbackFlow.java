package com.dph.request.aggregator.lib.flow.callback;

import org.springframework.http.HttpEntity;

import com.dph.request.aggregator.lib.flow.main.AggregatorContext;

public class AggregatorCallbackFlow<K, V> {

    private AggregatorContext<K, V> contextFlow;

    private AggregatorCallbackFlowDataMapper aggregatorCallbackFlowOperation;

    public AggregatorCallbackFlow(AggregatorCallbackFlowDataMapper aggregatorCallbackFlowOperation) {
        this.aggregatorCallbackFlowOperation = aggregatorCallbackFlowOperation;
    }

    public void execute(HttpEntity<?> value) {
        aggregatorCallbackFlowOperation.process(value);
    }
}
