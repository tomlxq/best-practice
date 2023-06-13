package com.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CommonUtilsTest
 *
 * @author TomLuo
 * @date 2023年06月04日 21:59
 */
@Slf4j
class CommonUtilsTest {

    @Test
    void calculateCheckDigit() {
       log.info("{}",CommonUtils.calculateCheckDigit(1684059940123L));
       log.info("{}",CommonUtils.calculateCheckDigit(1684059940129L));

    }
}