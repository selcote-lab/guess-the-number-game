package com.tonasolution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Very coool");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        NumberGenerated numberGenerated = context.getBean("numberGenerator", NumberGenerated.class);

        int number = numberGenerated.next();

        log.info("number = {} ", number );

        context.close();

    }
}
