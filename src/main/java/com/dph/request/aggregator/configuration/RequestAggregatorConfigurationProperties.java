package com.dph.request.aggregator.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = RequestAggregatorConfigurationProperties.BASE_PATH)
public class RequestAggregatorConfigurationProperties {

    public static final String BASE_PATH = "cpm.dph.request.aggregator";

    private long timeOut;

    private int countSignals;

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public int getCountSignals() {
        return countSignals;
    }

    public void setCountSignals(int countSignals) {
        this.countSignals = countSignals;
    }
}
