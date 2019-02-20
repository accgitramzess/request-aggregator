package com.dph.request.aggregator.asynchronous;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by LilG2pac on 19.05.2018.
 */
public class RendezvousDataStorage<T> {

    private AtomicReference<T> dataRef;

    public RendezvousDataStorage() {
        this.dataRef = new AtomicReference<>();
    }

    public RendezvousDataStorage(T data) {
        this.dataRef = new AtomicReference<>(data);
    }

    public T getData() {
        return dataRef.get();
    }

    public void setData(T data) {
        T oldData = this.getData();
        for(;;) {
            boolean compareAndSetResult = dataRef.compareAndSet(oldData, data);
            if(compareAndSetResult) {
                // the data exchange process is completed successfully.
                return;
            }
        }
    }

    public boolean isValid() {
        return dataRef.get() != null;
    }
}
