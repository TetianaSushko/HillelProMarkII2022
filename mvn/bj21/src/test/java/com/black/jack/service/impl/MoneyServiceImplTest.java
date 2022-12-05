package com.black.jack.service.impl;

import com.black.jack.dto.Game;
import com.black.jack.dto.Player;
import com.black.jack.service.GameService;
import com.black.jack.service.MoneyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyServiceImplTest {

    @Test
    void addMoneyToAmount() {
        Player pl = new Player().setName("pl_1").setAmount(100);
        GameService gs = new GameImpl();
        Game game = gs.startGame(pl);

        MoneyService ms = new MoneyServiceImpl();
        ms.addMoneyToAmount(game, 50);

        Assertions.assertEquals(150, game.getPlayer().getAmount());
    }

    @Test
    void subMoneyFromAmount() {
        Player pl = new Player().setName("pl_1").setAmount(100);
        GameService gs = new GameImpl();
        Game game = gs.startGame(pl);

        MoneyService ms = new MoneyServiceImpl();
        ms.subMoneyFromAmount(game, 50);

        Assertions.assertEquals(50, game.getPlayer().getAmount());
    }

    @Test
    void checkBalance() {
        Player pl = new Player().setName("pl_1").setAmount(100);
        GameService gs = new GameImpl();
        Game game = gs.startGame(pl);

        MoneyService ms = new MoneyServiceImpl();
        Assertions.assertTrue( ms.checkBalance(game, 50));

        game.getPlayer().setAmount(50);
        Assertions.assertTrue( ms.checkBalance(game, 50));

        game.getPlayer().setAmount(40);
        Assertions.assertFalse( ms.checkBalance(game, 50));
    }
}