package com.dph.blocked.service.game;

public class Pair {

    private final Card defender;

    private final Card attacker;

    public Pair(Card defender, Card attacker) {
        this.defender = defender;
        this.attacker = attacker;
    }

    public Card getDefender() {
        return defender;
    }

    public Card getAttacker() {
        return attacker;
    }
}
