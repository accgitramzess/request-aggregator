package com.dph.blocked.service;

import org.springframework.web.client.RestTemplate;

import com.dph.blocked.service.dto.Request;
import com.dph.blocked.service.dto.Response;

public class BlockedService {

    private String url;

    private RestTemplate restTemplate;

    private RequestAggregatorSupport<Response> requestAggregatorSupport;

    public BlockedService(String url, RestTemplate restTemplate, RequestAggregatorSupport<Response> requestAggregatorSupport) {
        this.url = url;
        this.restTemplate = restTemplate;
        this.requestAggregatorSupport = requestAggregatorSupport;
    }

    public Response download(Request request) {
        return requestAggregatorSupport.startSession(
                () -> restTemplate.postForObject(url, request, Response.class)
        );
    }
}
