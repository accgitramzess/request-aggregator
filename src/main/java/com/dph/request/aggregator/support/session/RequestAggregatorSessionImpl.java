package com.dph.request.aggregator.support.session;

import com.dph.request.aggregator.interfaces.RequestAggregatorSession;
import com.dph.request.aggregator.interfaces.RequestAggregatorOperation;
import com.dph.request.aggregator.interfaces.RequestAggregatorThreadParkAlgorithm;

public class RequestAggregatorSessionImpl implements RequestAggregatorSession<Class<?>> {

    private Class<?> result;

    private RequestAggregatorThreadParkAlgorithm threadParkAlgorithm;

    public RequestAggregatorSessionImpl(RequestAggregatorThreadParkAlgorithm threadParkAlgorithm) {
        this.threadParkAlgorithm = threadParkAlgorithm;
    }

    public void startSession(RequestAggregatorOperation<Class<?>> blockedOperation) {
        result = blockedOperation.execute();
        try {
            threadParkAlgorithm.park();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endSession() {
        try {
            threadParkAlgorithm.unpark();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Class<?> getSessionResult() {
        return result;
    }
}
