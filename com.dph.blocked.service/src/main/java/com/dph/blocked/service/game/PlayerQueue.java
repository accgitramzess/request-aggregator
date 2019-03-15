package com.dph.blocked.service.game;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerQueue {

    private int queueSize;

    private Queue<Integer> playerQueue;

    public PlayerQueue(int queueSize) {
        playerQueue = new LinkedList<>();
    }
}
