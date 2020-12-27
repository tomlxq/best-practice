package com.example.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackExample {

    private static final Logger logger = LoggerFactory.getLogger(LogbackExample.class);

    public static void main(String[] args) {
        logger.debug("debug log message");
        logger.info("info log message");
        logger.error("error log message");
    }

}
