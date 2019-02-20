package com.dph.request.aggregator.asynchronous;

/**
 * Created by LilG2pac on 19.05.2018.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RendezvousSupport<K, D> {

    private Map<K, RendezvousRoom<D>> rendezvousRooms;

    private FailedRendezvousManager failedRendezvousManager;

    public RendezvousSupport(FailedRendezvousManager failedRendezvousManager) {
        this.rendezvousRooms = new HashMap<>();
        this.failedRendezvousManager = failedRendezvousManager;
    }

    public D enterFoWaiting(long TIMEOUT, K key) {

        RendezvousRoom<D> rendezvousRoom = new RendezvousRoom<>();
        rendezvousRooms.put(key, rendezvousRoom);

        rendezvousRoom.enterFoWaiting(TIMEOUT, TimeUnit.SECONDS);

        if(!rendezvousRoom.isRendezvousSuccessful()) {
            failedRendezvousManager.registerFailedRendezvous();
        }

        rendezvousRooms.remove(key);

        return rendezvousRoom.getData();
    }

    public void rendezvous(K key, D data) {

        RendezvousRoom rendezvousRoom = rendezvousRooms.get(key);
        rendezvousRoom.rendezvous(data);

        if(!rendezvousRoom.isRendezvousSuccessful()) {
            failedRendezvousManager.registerFailedRendezvous();
        }
    }
}
