package com.dph.blocked.service.game;

import java.util.ArrayList;
import java.util.List;

public class RoundHistory {

    private List<Pair> roundHistory;

    public RoundHistory() {
        this(new ArrayList<>());
    }

    public RoundHistory(List<Pair> roundHistory) {
        this.roundHistory = roundHistory;
    }

    public void addPair(Pair pair) {
        roundHistory.add(pair);
    }
}
