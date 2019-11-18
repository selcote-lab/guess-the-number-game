package com.tonasolution.console;

import com.tonasolution.Game;
import com.tonasolution.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);
    // == fields ==
    @Autowired
    private Game game;
    @Autowired
    private MessageGenerator messangeGenerator;

    // == public methods ==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info(" start() -> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(messangeGenerator.getMainMessage());
            System.out.println(messangeGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messangeGenerator.getResultMessage());
                System.out.println("Play again y/n ?");

                String playAgainString = scanner.nextLine().trim();

                if(!playAgainString.equals("y")) {
                    break;
                }

                game.reset();
            }

        }
    }
}
