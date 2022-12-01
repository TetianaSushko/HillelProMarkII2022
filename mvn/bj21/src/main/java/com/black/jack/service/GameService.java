package com.black.jack.service;

import com.black.jack.dto.Card;
import com.black.jack.dto.Game;
import com.black.jack.dto.Player;

import java.util.List;

public interface GameService {
    Game startGame(Player player);

    void userTurn(Game game);

    void computerTurn(Game game);

    int showHand (Game game);

    void showWinner(Game game);
}
