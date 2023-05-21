package com.tom.log4j;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
        logger.warn("Warn log message");
        logger.trace("trace log message");
        logger.error("error log message");
    }
}
