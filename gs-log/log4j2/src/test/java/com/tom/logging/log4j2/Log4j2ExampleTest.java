package com.tom.logging.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/27
 */
public class Log4j2ExampleTest {

    private static final Logger logger = LogManager.getLogger(Log4j2Example.class);

    @Test
    public void testName() {

        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
        logger.warn("Warn log message");
        logger.fatal("Fatal log message");
        logger.trace("Trace log message");
        try {
            throw new RuntimeException("there is a error");
        } catch (Exception e) {
            logger.error("Error log message", e);
        }
        System.out.printf("test");
    }
}