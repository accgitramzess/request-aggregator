package com.dph.request.aggregator.lib.configuration;

import com.dph.request.aggregator.lib.flow.dto.AggregatorRequest;

import java.util.UUID;

public class RequestTest extends AggregatorRequest<UUID> {

    private String callback;

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getCallback() {
        return callback;
    }
}
