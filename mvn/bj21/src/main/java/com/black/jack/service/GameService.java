package com.black.jack.service;

import com.black.jack.dto.Game;
import com.black.jack.dto.Player;

import java.util.List;

public interface GameService {
    Game startGame(Player player);

    void userTurn(Game game);

    void computerTurn(Game game);

    int showHand (Game game);

    void showWinner(Game game, int gameAmmount);

    void clearHand(Game game);

    void updateDeck(Game game);

    String showResult(Game game);

    boolean isOverScore(Game game);
}
