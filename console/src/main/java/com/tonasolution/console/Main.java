package com.tonasolution.console;

import com.tonasolution.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import(GameConfig.class)
public class Main {

    public static void main(String[] args) {
        log.info("Guess The number Game");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        context.close();
    }
}
