package com.black.jack;

import com.black.jack.dto.Game;
import com.black.jack.dto.Player;
import com.black.jack.service.GameService;
import com.black.jack.service.MoneyService;
import com.black.jack.service.impl.GameImpl;
import com.black.jack.service.impl.MoneyServiceImpl;

import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter your name ...");
        String name = cs.nextLine();
        System.out.println("Put money into ...");
        Integer amount = cs.nextInt();
        System.out.println("Enter number of games ...");
        Integer numberOfGames = cs.nextInt();
        cs.nextLine();

        GameService gs = new GameImpl();
        MoneyService ms = new MoneyServiceImpl();
        Game game = gs.startGame(new Player()
                                .setName(name)
                                .setAmount(amount));

        gs.computerTurn(game);
        String contitue = "Y";
        String stopGame = "Y";

        do{
            System.out.println("Please put your bet:");
            int gameAmount = cs.nextInt();
            cs.nextLine();
            if (!ms.checkBalance(game, gameAmount)) {
                System.out.printf("You can put %s $. Continue [Y/N]%n", game.getPlayer().getAmount());
                String des = cs.nextLine();

                if (!des.equalsIgnoreCase("y")){
                    System.out.println("Please put your new bet:");
                    gameAmount = cs.nextInt();
                    cs.nextLine();
                } else {
                    gameAmount = game.getPlayer().getAmount();
                }
            }
            game.setGameAmount(gameAmount);
            do {
                gs.userTurn(game);
                if (gs.isOverScore(game)) break;
                System.out.println("Next card ... [Y/N]");
                contitue = cs.nextLine();
            } while (contitue.equalsIgnoreCase("y"));
            gs.showWinner(game, gameAmount);
            if (--numberOfGames == 0) break;
            gs.clearHand(game);
            gs.updateDeck(game);
            System.out.println("Continue game ... [Y/N]");
            stopGame = cs.nextLine();
        } while (stopGame.equalsIgnoreCase("y"));

        System.out.println(gs.showResult(game));
    }
}
