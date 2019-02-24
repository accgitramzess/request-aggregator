package com.dph.request.aggregator.interfaces;

public interface RequestAggregatorSession<SESSION_RESULT> {

    void startSession(RequestAggregatorOperation<Class<?>> blockedOperation);

    void endSession();

    SESSION_RESULT getSessionResult();
}
