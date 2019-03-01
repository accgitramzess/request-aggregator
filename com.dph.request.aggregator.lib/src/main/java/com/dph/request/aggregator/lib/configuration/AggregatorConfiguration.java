package com.dph.request.aggregator.lib.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dph.request.aggregator.lib.support.RequestAggregatorSupport;
import com.dph.request.aggregator.lib.support.park.RequestAggregatorThreadParkCountDownLatchAlgorithm;
import com.dph.request.aggregator.lib.support.listener.DefaultListener;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Configuration
public class AggregatorConfiguration {

    private RequestAggregatorConfigurationProperties properties;

    @Bean
    public RequestAggregatorSupport requestAggregator() {
        return new RequestAggregatorSupport<>(
                properties,
                new DefaultListener(),
                new RequestAggregatorThreadParkCountDownLatchAlgorithm(
                        0L,
                        TimeUnit.MILLISECONDS,
                        0,
                        new CountDownLatch(properties.getCountSignals())
                )
        );
    }
}
