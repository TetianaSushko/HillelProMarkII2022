package com.black.jack.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Stack;

@Data
@Accessors(chain = true)
public class Game {
    private Player player;
    private Computer computer;
    private Stack<Card> cardDeck;
    private int gameAmount;
}
