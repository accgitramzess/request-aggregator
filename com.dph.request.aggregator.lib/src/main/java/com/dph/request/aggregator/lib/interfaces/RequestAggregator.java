package com.dph.request.aggregator.lib.interfaces;

public interface RequestAggregator<RESPONSE_TYPE, ES_INPUT> {

    RESPONSE_TYPE startSession(RequestAggregatorOperation<RESPONSE_TYPE> blockedOperation);

    void endSession(ES_INPUT input);
}
