package com.dph.request.aggregator.asynchronous;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by LilG2pac on 19.05.2018.
 */
public class RendezvousRoom<T> {

    private RendezvousDataStorage<T> storage;

    private CountDownLatch countDownLatch;

    public RendezvousRoom() {
        this.countDownLatch = new CountDownLatch(1);
        this.storage = new RendezvousDataStorage<>();
    }

    public boolean isRendezvousSuccessful() {
        return storage.isValid();
    }

    public T getData() {
        return storage.getData();
    }

    public void enterFoWaiting(long timeout, TimeUnit timeUnit) {
        try {
            countDownLatch.await(timeout, timeUnit);
        } catch (InterruptedException ignored) {
        }
    }

    public void rendezvous(T data) {
        storage.setData(data);
        countDownLatch.countDown();
    }
}
