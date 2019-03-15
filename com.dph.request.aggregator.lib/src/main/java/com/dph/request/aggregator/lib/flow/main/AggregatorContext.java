package com.dph.request.aggregator.lib.flow.main;

import java.util.concurrent.locks.LockSupport;

public class AggregatorContext<V> {

    private long timeout;

    private V value;

    private Thread thread;

    public AggregatorContext(long timeout) {
        this.timeout = timeout;
    }

    public V waitSignal() {
        this.thread = Thread.currentThread();
        LockSupport.parkUntil(this, timeout);

        return value;
    }

    public void releaseSignal(V value) {
        this.value = value;
        LockSupport.unpark(thread);
    }
}
