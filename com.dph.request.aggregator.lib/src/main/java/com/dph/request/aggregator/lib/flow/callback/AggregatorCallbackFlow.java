package com.dph.request.aggregator.lib.flow.callback;

import org.springframework.http.HttpEntity;

public class AggregatorCallbackFlow {

    private AggregatorCallbackFlowOperation aggregatorCallbackFlowOperation;

    public AggregatorCallbackFlow(AggregatorCallbackFlowOperation aggregatorCallbackFlowOperation) {
        this.aggregatorCallbackFlowOperation = aggregatorCallbackFlowOperation;
    }

    public void execute(HttpEntity<?> value) {
        aggregatorCallbackFlowOperation.process(value);
    }
}
