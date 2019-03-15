package com.dph.blocked.service.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckGenerator {

    private static int DECK_SIZE = 36;

    private final int deckSize;

    public DeckGenerator() {
        this(DECK_SIZE);
    }

    public DeckGenerator(int deckSize) {
        this.deckSize = deckSize;
    }

    public Deck generate() {
        List<Card> cards = new ArrayList<>();

        CardName [] cardNames = CardName.values();

        CardSuit [] cardSuits = CardSuit.values();

        for (int i = 0; i < deckSize; i++) {
            for (CardSuit cardSuit : cardSuits) {
                Card card = new Card(cardNames[i], cardSuit);
                cards.add(card);
            }
        }

        Collections.shuffle(cards);

        return new Deck(cards);
    }
}
