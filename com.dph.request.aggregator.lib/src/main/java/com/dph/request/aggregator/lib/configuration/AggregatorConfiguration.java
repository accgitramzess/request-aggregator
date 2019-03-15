package com.dph.request.aggregator.lib.configuration;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AggregatorConfiguration {

    @Bean
    public Aggregator<UUID, RequestTest> aggregatorRequestFlow() {
        return new Aggregator<>(5000);
    }
}