package com.dph.request.aggregator.support;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.dph.request.aggregator.interfaces.RequestAggregatorFailedSessionListener;
import com.dph.request.aggregator.interfaces.RequestAggregator;
import com.dph.request.aggregator.interfaces.RequestAggregatorOperation;
import com.dph.request.aggregator.interfaces.RequestAggregatorThreadParkAlgorithm;
import com.dph.request.aggregator.configuration.RequestAggregatorConfigurationProperties;
import com.dph.request.aggregator.messages.AggregatorResponse;
import com.dph.request.aggregator.support.session.RequestAggregatorSessionImpl;

public class RequestAggregatorSupport implements RequestAggregator<Class<?>, AggregatorResponse> {

    private RequestAggregatorConfigurationProperties properties;

    private RequestAggregatorFailedSessionListener failedSessionListener;

    private RequestAggregatorThreadParkAlgorithm threadParkAlgorithm;

    private Map<UUID, RequestAggregatorSessionImpl> activeSessions;

    public RequestAggregatorSupport(RequestAggregatorConfigurationProperties properties,
                                    RequestAggregatorFailedSessionListener failedSessionListener,
                                    RequestAggregatorThreadParkAlgorithm threadParkAlgorithm) {
        this.properties = properties;
        this.failedSessionListener = failedSessionListener;
        this.threadParkAlgorithm = threadParkAlgorithm;
        this.activeSessions = new ConcurrentHashMap<>();
    }

    @Override
    public Class<?> startSession(RequestAggregatorOperation<Class<?>> blockedOperation) {
        UUID sessionId = UUID.randomUUID();

        RequestAggregatorSessionImpl session = new RequestAggregatorSessionImpl(threadParkAlgorithm);
        activeSessions.put(sessionId, session);

        session.startSession(blockedOperation);

        RequestAggregatorSessionImpl activeSession = activeSessions.remove(sessionId);

        Class<?> sessionResult = activeSession.getSessionResult();
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
