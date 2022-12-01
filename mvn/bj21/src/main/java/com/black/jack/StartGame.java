package com.black.jack;

import com.black.jack.dto.Game;
import com.black.jack.dto.Player;
import com.black.jack.service.GameService;
import com.black.jack.service.impl.GameImpl;

import java.util.Locale;
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
        Game game = gs.startGame(new Player()
                                .setName(name)
                                .setAmount(amount));

        gs.computerTurn(game);

        String contitue = "Y";

        do {
            gs.userTurn(game);
            System.out.println("Continue ... [Y/N]");
            contitue = cs.nextLine();
        }while (contitue.toLowerCase().equals("y"));

        gs.showWinner(game);

    }
}
