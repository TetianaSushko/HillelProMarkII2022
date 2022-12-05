package com.black.jack.service;

import com.black.jack.dto.Game;

public interface MoneyService {

    void addMoneyToAmount(Game game, int amount);

    void subMoneyFromAmount(Game game, int amount);

    boolean checkBalance(Game game, int amount);
}
