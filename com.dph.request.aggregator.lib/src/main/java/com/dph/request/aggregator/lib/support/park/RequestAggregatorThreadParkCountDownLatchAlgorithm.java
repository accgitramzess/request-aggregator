package com.dph.request.aggregator.lib.support.park;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.dph.request.aggregator.lib.interfaces.RequestAggregatorThreadParkAlgorithm;

public class RequestAggregatorThreadParkCountDownLatchAlgorithm implements RequestAggregatorThreadParkAlgorithm {

    private int amountAttempts;

    private long timeout;

    private TimeUnit timeUnit;

    private CountDownLatch countDownLatch;

    public RequestAggregatorThreadParkCountDownLatchAlgorithm(long timeout,
                                                              TimeUnit timeUnit,
                                                              int amountAttempts,
                                                              CountDownLatch countDownLatch) {
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.amountAttempts = amountAttempts;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void park() {
        while(amountAttempts > 0) {
            try {
                countDownLatch.await(timeout, timeUnit);
            } catch (InterruptedException ignored) {
            }
            amountAttempts --;
        }
    }

    @Override
    public void unpark() {
        countDownLatch.countDown();
    }
}
