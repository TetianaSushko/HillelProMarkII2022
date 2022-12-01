package com.black.jack.service.impl;

import com.black.jack.dto.Card;
import com.black.jack.dto.Computer;
import com.black.jack.dto.Game;
import com.black.jack.dto.Player;
import com.black.jack.service.CardDeck;
import com.black.jack.service.GameService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class GameImpl implements GameService {

    private final CardDeck cd = new CardDeckImpl();

    @Override
    public Game startGame(Player player) {
        return new Game()
                .setPlayer(player)
                .setComputer(new Computer())
                .setCardDeck(new CardDeckImpl().getDeck());
    }

    @Override
    public void userTurn(Game game) {
//        game
//          .getPlayer()
//              .getHand().add(cd.getCard(game.getCardDeck()));

        Card card = cd.getCard(game.getCardDeck());

        Player pl = game.getPlayer();
        List<Card> hand = pl.getHand();
        hand.add(card);

        System.out.println("score : " + showHand(game));
    }

    @Override
    public int showHand(Game game) {
        List<Card> hand = game.getPlayer().getHand();

        int amount = 0;
        for (Card card : hand){
            amount += card.getCost();
            System.out.print(card + " ");
        }
        System.out.println();
        return amount;
    }

    @Override
    public void computerTurn(Game game) {
        // 17 - 25
        game.getComputer().setHand(new Random().nextInt(25 - 17) + 17);
    }

    @Override
    public void showWinner(Game game) {
        int pScore = showHand(game);
        int cScore = game.getComputer().getHand();

        System.out.println("Player score : " + pScore);
        System.out.println("Computer score : " + cScore);

        if (pScore == cScore) {
            System.out.println("Drujba");
        } else if (cScore > pScore) {
            System.out.println("Computer");
        } else {
            System.out.println("Player");
        }
    }
}
