package com.black.jack.service.impl;

import com.black.jack.dto.Game;
import com.black.jack.service.MoneyService;

public class MoneyServiceImpl implements MoneyService {

    @Override
    public void addMoneyToAmount(Game game, int amount) {
        game.getPlayer().setAmount(game.getPlayer().getAmount() + amount);
    }

    @Override
    public void subMoneyFromAmount(Game game, int amount) {
        game.getPlayer().setAmount(game.getPlayer().getAmount() - amount);
    }

    @Override
    public boolean checkBalance(Game game, int amount) {
        return game.getPlayer().getAmount() >= amount;
    }
}
