package com.black.jack.service;

import com.black.jack.dto.Card;
import com.black.jack.exception.CardDeckEmptyException;

import java.util.Stack;

public interface CardDeck {
    Stack<Card> getDeck();

    Card getCard(Stack<Card> cardDeck) throws CardDeckEmptyException;
}
