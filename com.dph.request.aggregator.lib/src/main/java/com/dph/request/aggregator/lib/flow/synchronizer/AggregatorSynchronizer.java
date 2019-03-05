package com.dph.request.aggregator.lib.flow.synchronizer;

public interface AggregatorSynchronizer {

    void park();

    void unpark();
}
