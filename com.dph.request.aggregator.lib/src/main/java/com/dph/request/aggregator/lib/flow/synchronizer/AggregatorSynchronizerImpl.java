package com.dph.request.aggregator.lib.flow.synchronizer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AggregatorSynchronizerImpl implements AggregatorSynchronizer {

    private int amountAttempts;

    private long timeout;

    private TimeUnit timeUnit;

    private CountDownLatch countDownLatch;

    public AggregatorSynchronizerImpl(long timeout, TimeUnit timeUnit, int amountAttempts, CountDownLatch countDownLatch) {
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
