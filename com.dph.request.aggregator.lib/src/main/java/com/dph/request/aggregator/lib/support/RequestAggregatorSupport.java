package com.dph.request.aggregator.lib.support;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.dph.request.aggregator.lib.interfaces.*;
import com.dph.request.aggregator.lib.configuration.RequestAggregatorConfigurationProperties;
import com.dph.request.aggregator.lib.messages.AggregatorResponse;
import com.dph.request.aggregator.lib.support.session.RequestAggregatorSessionImpl;

public class RequestAggregatorSupport<T> implements RequestAggregator<T, AggregatorResponse> {

    private RequestAggregatorConfigurationProperties properties;

    private RequestAggregatorFailedSessionListener failedSessionListener;

    private RequestAggregatorThreadParkAlgorithm threadParkAlgorithm;

    //private RequestAggregatorSessionIdProvider sessionIdProvider;

    private Map<UUID, RequestAggregatorSessionImpl<T>> activeSessions;

    public RequestAggregatorSupport(RequestAggregatorConfigurationProperties properties,
                                    RequestAggregatorFailedSessionListener failedSessionListener,
                                    RequestAggregatorThreadParkAlgorithm threadParkAlgorithm) {
        this.properties = properties;
        this.failedSessionListener = failedSessionListener;
        this.threadParkAlgorithm = threadParkAlgorithm;
        this.activeSessions = new ConcurrentHashMap<>();
    }

    @Override
    public T startSession(RequestAggregatorOperation<T> blockedOperation) {
        UUID sessionId = UUID.randomUUID();

        RequestAggregatorSessionImpl<T> session = new RequestAggregatorSessionImpl(threadParkAlgorithm);
        activeSessions.put(sessionId, session);

        session.startSession(blockedOperation);

        RequestAggregatorSessionImpl<T> activeSession = activeSessions.remove(sessionId);

        T sessionResult = activeSession.getSessionResult();
        if (sessionResult == null) {
            failedSessionListener.log();
        }

        return sessionResult;
    }

    @Override
    public void endSession(AggregatorResponse aggregatorResponse) {
        RequestAggregatorSessionImpl session = activeSessions.get(null);
        session.endSession();
    }
}
