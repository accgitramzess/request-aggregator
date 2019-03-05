package com.dph.request.aggregator.lib.flow.request;

import com.dph.request.aggregator.lib.flow.data.SharedData;

public class AggregateRequestFlowOperationContext<K, V> {

    private K flowId;

    private SharedData<K, V> sharedData;

    private AggregateRequestFlowOperationStatus status;

    public K getFlowId() {
        return flowId;
    }

    public void setFlowId(K flowId) {
        this.flowId = flowId;
    }

    public AggregateRequestFlowOperationStatus getStatus() {
        return status;
    }

    public void setStatus(AggregateRequestFlowOperationStatus status) {
        this.status = status;
    }

    public void setSharedData(SharedData<K, V> sharedData) {
        this.sharedData = sharedData;
    }

    public V getData() {
        return sharedData.endHandshake(flowId);
    }
}
