package com.dph.request.aggregator.lib.interfaces;

public interface RequestAggregatorSessionIdProvider<OUTPUT> {

    OUTPUT getSessionId();
}
