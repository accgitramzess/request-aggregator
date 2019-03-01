package com.dph.request.aggregator.lib.interfaces;

public interface ResponseAggregatorOperation<INPUT, OUTPUT> {

    OUTPUT execute(INPUT input);
}
