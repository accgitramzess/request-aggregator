package com.dph.request.aggregator.support.park;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.dph.request.aggregator.interfaces.RequestAggregatorThreadParkAlgorithm;

public class RequestAggregatorThreadParkCountDownLatchAlgorithm implements RequestAggregatorThreadParkAlgorithm {

    private int amountAttempts;

    private long timeout;

    private TimeUnit timeUnit;

    private CountDownLatch countDownLatch;

    public RequestAggregatorThreadParkCountDownLatchAlgorithm(int countSignals) {
        this.countDownLatch = new CountDownLatch(countSignals);
    }

    @Override
    public void park() throws Exception {
        while(amountAttempts > 0) {
            try {
                countDownLatch.await(timeout, timeUnit);
            } catch (InterruptedException ignored) {
            }
            amountAttempts --;
        }
    }

    @Override
    public void unpark() throws Exception {

    }
}
