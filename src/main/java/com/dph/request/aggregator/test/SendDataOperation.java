package com.dph.request.aggregator.test;

import org.springframework.web.client.RestTemplate;

import com.dph.request.aggregator.interfaces.RequestAggregatorOperation;

public class SendDataOperation implements RequestAggregatorOperation<String> {

    private RestTemplate restTemplate;

    private MyRequest myRequest;

    public SendDataOperation(RestTemplate restTemplate, MyRequest myRequest) {
        this.restTemplate = restTemplate;
        this.myRequest = myRequest;
    }

    @Override
    public String execute() {
        return restTemplate.postForEntity("", myRequest, String.class).getBody();
    }
}
