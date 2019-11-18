package com.tonasolution.console;

import com.tonasolution.config.AppConfig;
import com.tonasolution.Game;
import com.tonasolution.MessageGenerator;
import com.tonasolution.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Very Cool");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        int number = numberGenerator.next();
        log.info("number = {} ", number );

        Game game = context.getBean(Game.class);
        game.reset();

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {} ",  messageGenerator.getMainMessage());
        log.info("getResultMessage() = {} ", messageGenerator.getResultMessage());

        context.close();
    }
}
