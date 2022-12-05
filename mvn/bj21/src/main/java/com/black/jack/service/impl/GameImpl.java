package com.black.jack.service.impl;

import com.black.jack.dto.Card;
import com.black.jack.dto.Computer;
import com.black.jack.dto.Game;
import com.black.jack.dto.Player;
import com.black.jack.dto.Result;
import com.black.jack.service.CardDeck;
import com.black.jack.service.GameService;
import com.black.jack.service.MoneyService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class GameImpl implements GameService {

    private final CardDeck cd = new CardDeckImpl();
    private final MoneyService moneyService = new MoneyServiceImpl();

    @Override
    public Game startGame(Player player) {
        return new Game()
                .setPlayer(player)
                .setComputer(new Computer())
                .setCardDeck(new CardDeckImpl().getDeck());
    }

    @Override
    public void userTurn(Game game) {
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
        for (Card card : hand) {
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

    //todo - add additional tests
    @Override
    public void showWinner(Game game, int gameAmount) {
        int pScore = showHand(game);
        int cScore = game.getComputer().getHand();

        System.out.println("Player score : " + pScore);
        System.out.println("Computer score : " + cScore);

        if (pScore > 21 && cScore > 21) {
            System.out.println(Result.LOSE);
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
            moneyService.subMoneyFromAmount(game, gameAmount);
        } else if (pScore <= 21 && cScore > 21) {
            System.out.println(Result.PLAYER);
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
            game.getPlayer().setNumberOfWinGames(game.getPlayer().getNumberOfWinGames() + 1);
            moneyService.addMoneyToAmount(game, gameAmount);
        } else if (pScore > 21) {
            System.out.println(Result.COMPUTER);
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
            moneyService.subMoneyFromAmount(game, gameAmount);
        } else if (pScore == cScore) {
            System.out.println(Result.DRAW);
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
        } else if (pScore > cScore) {
            System.out.println(Result.PLAYER);
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
            game.getPlayer().setNumberOfWinGames(game.getPlayer().getNumberOfWinGames() + 1);
            moneyService.addMoneyToAmount(game, gameAmount);
        } else {
            System.out.println(Result.COMPUTER);
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
            moneyService.subMoneyFromAmount(game, gameAmount);
        }
    }

    @Override
    public void clearHand(Game game) {
        game.getPlayer().setHand(new ArrayList<>());
    }

    @Override
    public void updateDeck(Game game) {
        game.setCardDeck(cd.getDeck());
    }

    @Override
    public String showResult(Game game) {
        return String.format("Player : %s win %s games from %s total games and earn %s $ ...",
                game.getPlayer().getName(),
                game.getPlayer().getNumberOfWinGames(),
                game.getPlayer().getNumberOfGames(),
                game.getPlayer().getAmount());
    }

    @Override
    public boolean isOverScore(Game game) {
        return showHand(game) > 21;
    }
}
