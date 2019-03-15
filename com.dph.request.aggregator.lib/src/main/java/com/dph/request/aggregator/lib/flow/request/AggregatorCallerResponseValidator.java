package com.dph.request.aggregator.lib.flow.request;

public interface AggregatorCallerResponseValidator<V> {

    void validate(V value) throws Exception;
}
