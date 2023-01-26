package com.black.jack;

import com.black.jack.dto.Game;
import com.black.jack.dto.Player;
import com.black.jack.service.GameService;
import com.black.jack.service.MoneyService;
import com.black.jack.service.impl.GameImpl;
import com.black.jack.service.impl.MoneyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class StartGame {
    private static final Logger logger = LoggerFactory.getLogger("stdout");
    private static final Logger save = LoggerFactory.getLogger("logger");

    public static void main(String[] args) {
        Locale defLocale = Locale.getDefault();
        if (args.length != 0) {
            defLocale = new Locale(args[0]);
        }
        ResourceBundle
                resourceBundle = ResourceBundle.getBundle("message", defLocale);

        Scanner cs = new Scanner(System.in);
        logger.info(resourceBundle.getString("enter_name"));
        String name = cs.nextLine();
        logger.info(resourceBundle.getString("money"));
        Integer amount = cs.nextInt();
        logger.info(resourceBundle.getString("number_of_games"));
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
            logger.info("Please put your bet:");
            int gameAmount = cs.nextInt();
            cs.nextLine();
            if (!ms.checkBalance(game, gameAmount)) {
                System.out.printf("You can put %s $. Continue [Y/N]%n", game.getPlayer().getAmount());
                String des = cs.nextLine();

                if (!des.equalsIgnoreCase("y")){
                    logger.info("Please put your new bet:");
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
                logger.info("Next card ... [Y/N]");
                contitue = cs.nextLine();
            } while (contitue.equalsIgnoreCase("y"));
            gs.showWinner(game, gameAmount);
            if (--numberOfGames == 0) break;
            gs.clearHand(game);
            gs.updateDeck(game);
            logger.info("Continue game ... [Y/N]");
            stopGame = cs.nextLine();
        } while (stopGame.equalsIgnoreCase("y"));

        save.info(gs.showResult(game));

    }
}
