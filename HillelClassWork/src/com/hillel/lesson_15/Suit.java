package com.hillel.lesson_15;

public enum Suit {
    Hearts('♥'),
    Clubs('♣'),
    Spades('♠'),
    Diamonds('♦');

    private final char symbol;

    public char getSymbol() {
        return symbol;
    }

    Suit(char symbol){
        this.symbol = symbol;
    }
}
