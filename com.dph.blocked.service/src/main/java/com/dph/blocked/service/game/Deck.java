package com.dph.blocked.service.game;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards(int countCards) {
        List<Card> removed = new ArrayList<>(countCards);
        for (int i = 0; i < countCards; i++) {
            removed.add(cards.get(i));
        }
        cards.removeAll(removed);

        return removed;
    }
}
