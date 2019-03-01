package com.dph.request.aggregator.lib.support.session;

import com.dph.request.aggregator.lib.interfaces.RequestAggregatorSession;
import com.dph.request.aggregator.lib.interfaces.RequestAggregatorOperation;
import com.dph.request.aggregator.lib.interfaces.RequestAggregatorThreadParkAlgorithm;

public class RequestAggregatorSessionImpl<T> implements RequestAggregatorSession<T> {

    private T result;

    private RequestAggregatorThreadParkAlgorithm threadParkAlgorithm;

    public RequestAggregatorSessionImpl(RequestAggregatorThreadParkAlgorithm threadParkAlgorithm) {
        this.threadParkAlgorithm = threadParkAlgorithm;
    }

    public void startSession(RequestAggregatorOperation<T> blockedOperation) {
        result = blockedOperation.execute();
        threadParkAlgorithm.park();
    }

    public void endSession() {
        threadParkAlgorithm.unpark();
    }

    @Override
    public T getSessionResult() {
        return result;
    }
}
