package com.dph.request.aggregator.lib.flow.callback;

import org.springframework.http.HttpEntity;

public interface AggregatorCallbackFlowOperation {

    void process(HttpEntity<?> entity);
}
