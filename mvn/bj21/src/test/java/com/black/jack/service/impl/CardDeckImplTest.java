package com.black.jack.service.impl;

import com.black.jack.dto.Card;
import com.black.jack.exception.CardDeckEmptyException;
import com.black.jack.service.CardDeck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class CardDeckImplTest {

    @Test
    void getDeck() {
        CardDeck cd = new CardDeckImpl();
        Stack<Card> cardDeck = cd.getDeck();
        Assertions.assertFalse(cardDeck.isEmpty());
        Assertions.assertEquals(52, cardDeck.size());
    }

    @Test
    void getCard() {
        CardDeck cd = new CardDeckImpl();
        Stack<Card> cardDeck = cd.getDeck();
        Assertions.assertFalse(cardDeck.isEmpty());
        Assertions.assertEquals(52, cardDeck.size());
        cd.getCard(cardDeck);
        Assertions.assertEquals(51, cardDeck.size());
    }

    @Test
    void emptyDeck(){
       Assertions.assertThrows(CardDeckEmptyException.class, () -> {
            CardDeck cd = new CardDeckImpl();
            Stack<Card> cardDeck = cd.getDeck();
            int count = cardDeck.size() + 1;
            for (int i = 0; i < count; i++){
                cd.getCard(cardDeck);
            }
        });
    }


}