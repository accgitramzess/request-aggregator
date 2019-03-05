package com.dph.request.aggregator.lib.configuration;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;

import com.dph.request.aggregator.lib.flow.request.AggregatorDataIdentifier;
import com.dph.request.aggregator.lib.flow.callback.AggregatorCallbackFlow;
import com.dph.request.aggregator.lib.flow.request.AggregatorRequestFlow;
import com.dph.request.aggregator.lib.flow.data.SharedData;
import com.dph.request.aggregator.lib.flow.request.AggregatorRequestFlowContextBuilder;

@Configuration
public class AggregatorConfiguration {

    private RequestAggregatorConfigurationProperties properties;

    @Bean
    public AggregatorDataIdentifier<UUID> aggregatorDataIdentifier() {
        return () -> UUID.randomUUID();
    }

    @Bean
    @Scope("singleton")
    public SharedData<UUID, Object> sharedData() {
        return new SharedData<>(new ConcurrentHashMap<>());
    }

    @Bean
    public AggregatorRequestFlowContextBuilder<UUID, Object> flowContextBuilder() {
        return new AggregatorRequestFlowContextBuilder<>(aggregatorDataIdentifier(), sharedData());
    }

    @Bean
    public AggregatorCallbackFlow aggregatorCallbackFlow() {
        return new AggregatorCallbackFlow((HttpEntity<?> entity) -> {
            SharedData<UUID, Object> uuidAggregatorResponseSharedData = sharedData();
            Object body = entity.getBody();
            uuidAggregatorResponseSharedData.startHandshake(null, null);
        });
    }

    @Bean
    public AggregatorRequestFlow<RequestTest, ResponseTest> aggregatorRequestFlow() {
        return new AggregatorRequestFlow<RequestTest, ResponseTest>(
                flowContextBuilder(),
                null);
    }
}