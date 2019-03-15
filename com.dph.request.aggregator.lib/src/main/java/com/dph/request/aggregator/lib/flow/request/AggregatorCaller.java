package com.dph.request.aggregator.lib.flow.request;

import org.springframework.web.client.RestTemplate;

import com.dph.request.aggregator.lib.flow.dto.AggregatorRequest;

public class AggregatorCaller<I, O> {

    private RestTemplate restTemplate;

    private AggregatorCallerResponseValidator<O> validator;

    public void process(AggregatorRequest<I> request) throws Exception {
        restTemplate.pos(request, O);

        validator.validate();
    }
}
