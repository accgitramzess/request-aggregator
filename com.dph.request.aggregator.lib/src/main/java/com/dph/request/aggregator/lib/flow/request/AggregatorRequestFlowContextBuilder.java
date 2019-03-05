package com.dph.request.aggregator.lib.flow.request;

import com.dph.request.aggregator.lib.flow.data.SharedData;

public class AggregatorRequestFlowContextBuilder<K, V> {

    private AggregatorDataIdentifier<K> idFactory;

    private SharedData<K, V> sharedData;

    public AggregatorRequestFlowContextBuilder(AggregatorDataIdentifier<K> idFactory, SharedData<K, V> sharedData) {
        this.idFactory = idFactory;
        this.sharedData = sharedData;
    }

    public AggregateRequestFlowOperationContext<K, V> build() {
        AggregateRequestFlowOperationContext<K, V> context = new AggregateRequestFlowOperationContext<>();
        context.setFlowId(idFactory.getDataIdentifier());
        context.setSharedData(sharedData);

        return context;
    }
}
