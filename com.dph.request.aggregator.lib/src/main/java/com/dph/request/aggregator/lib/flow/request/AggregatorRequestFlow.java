package com.dph.request.aggregator.lib.flow.request;

import com.dph.request.aggregator.lib.flow.synchronizer.AggregatorSynchronizer;
import com.dph.request.aggregator.lib.flow.synchronizer.AggregatorSynchronizerImpl2;

public class AggregatorRequestFlow<K, V> {

    private AggregatorRequestFlowContextBuilder<K, V> contextBuilder;

    private AggregateRequestFlowOperation operation;

    private AggregatorSynchronizer synchronizer;

    public AggregatorRequestFlow(AggregatorRequestFlowContextBuilder<K, V> contextBuilder,
                                 AggregateRequestFlowOperation operation) {
        this.contextBuilder = contextBuilder;
        this.operation = operation;
        this.synchronizer = new AggregatorSynchronizerImpl2();
    }

    public V aggregate() throws AggregatorRequestFlowException {
        AggregateRequestFlowOperationContext<K, V> context = contextBuilder.build();

        operation.process(context);

        if(context.getStatus() == AggregateRequestFlowOperationStatus.FAILED) {
            throw new AggregatorRequestFlowException();
        }

        synchronizer.park();

        V value = context.getData();
        if(value == null) {
            throw new AggregatorRequestFlowException();
        }

        return value;
    }
}
