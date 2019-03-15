package com.dph.request.aggregator.lib.configuration;

public class AggregatorException extends RuntimeException {

    public AggregatorException() {
    }

    public AggregatorException(Throwable cause) {
        super(cause);
    }

    public AggregatorException(String message) {
        super(message);
    }
}
