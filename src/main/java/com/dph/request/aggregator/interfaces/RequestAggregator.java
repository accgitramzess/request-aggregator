package com.dph.request.aggregator.interfaces;

import com.dph.request.aggregator.interfaces.RequestAggregatorOperation;

public interface RequestAggregator<RESPONSE_TYPE, ES_INPUT> {

    RESPONSE_TYPE startSession(RequestAggregatorOperation<Class<?>> blockedOperation);

    void endSession(ES_INPUT input);
}
