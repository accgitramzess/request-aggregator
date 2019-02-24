package com.dph.request.aggregator.interfaces;

public interface RequestAggregatorThreadParkAlgorithm {

    void park() throws Exception;

    void unpark() throws Exception;
}
