package com.dph.request.aggregator.lib.interfaces;

public interface RequestAggregatorSession<SESSION_RESULT> {

    void startSession(RequestAggregatorOperation<SESSION_RESULT> blockedOperation);

    void endSession();

    SESSION_RESULT getSessionResult();
}
