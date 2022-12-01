package com.black.jack.service.impl;

import com.black.jack.dto.Card;
import com.black.jack.dto.Rank;
import com.black.jack.dto.Suit;
import com.black.jack.exception.CardDeckEmptyException;
import com.black.jack.service.CardDeck;

import java.util.Collections;
import java.util.Stack;

public class CardDeckImpl implements CardDeck {
    @Override
    public Stack<Card> getDeck() {
        Stack<Card> cardDeck = new Stack<>();
        for (Suit suit : Suit.values()){
            for (Rank rant : Rank.values()){
                cardDeck.add(new Card(rant, suit));
            }
        }
        shuffleDeck(cardDeck);
        return cardDeck;
    }

    @Override
    public Card getCard(Stack<Card> cardDeck) throws CardDeckEmptyException {
        if (cardDeck.isEmpty())
            throw new CardDeckEmptyException();
        return cardDeck.pop();
    }

    private void shuffleDeck(Stack<Card> cardDeck){
        Collections.shuffle(cardDeck);
    }

}
