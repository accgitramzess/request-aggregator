package com.dph.blocked.service.game;

public class Card {

    private final CardName cardName;

    private final CardSuit cardSuit;

    public Card(CardName cardName, CardSuit cardSuit) {
        this.cardName = cardName;
        this.cardSuit = cardSuit;
    }
}