package com.dph.request.aggregator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dph.request.aggregator.interfaces.RequestAggregator;
import com.dph.request.aggregator.support.RequestAggregatorSupport;
import com.dph.request.aggregator.support.park.RequestAggregatorThreadParkCountDownLatchAlgorithm;
import com.dph.request.aggregator.support.listener.DefaultListener;

@Configuration
public class AggregatorConfiguration {

    private RequestAggregatorConfigurationProperties properties;

    @Bean
    public RequestAggregator requestAggregator() {
        return new RequestAggregatorSupport(
                properties,
                new DefaultListener(),
                new RequestAggregatorThreadParkCountDownLatchAlgorithm(properties.getCountSignals())
        );
    }
}
