package com.dph.blocked.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.dph.request.aggregator.lib.configuration.AggregatorConfiguration;
import com.dph.blocked.service.BlockedService;
import com.dph.blocked.service.dto.Response;
import com.dph.request.aggregator.lib.support.RequestAggregatorSupport;
import org.springframework.web.client.RestTemplate;

@Import(AggregatorConfiguration.class)
@Configuration
public class BlockedServiceConfiguration {

    @Autowired
    private RequestAggregatorSupport<Response> requestAggregatorSupport;

    @Bean
    public BlockedService blockedService() {
        return new BlockedService(
                "",
                new RestTemplate(),
                requestAggregatorSupport
        );
    }
}
