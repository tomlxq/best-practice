package com.example.lib;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * PreconditionsTest
 *
 * @author TomLuo
 * @date 2023年03月11日 23:35
 */
@Slf4j
public class PreconditionsTest {
    @Test
    void checkArgument() {
        int a = 1, b = 3;
        final String err = assertThrows(RuntimeException.class, () -> Preconditions.checkArgument(a > b).throwMessage("can not work")).getMessage();
        assertEquals("can not work", err);
    }

    @Test
    void isTureOrFalse() {
        int a = 1, b = 3;
        Preconditions.isTureOrFalse(a > b).trueOrFalseHandle(
                () -> log.info("a greater than b"),
                () -> log.info("a less than b"));
    }

    @Test
    void isBlankOrNoBlank() {
        Preconditions.isBlankOrNoBlank("Hello").presentOrElseHandle(
                System.out::println,
                () -> log.info("empty message"));
        Preconditions.isBlankOrNoBlank(null).presentOrElseHandle(
                System.out::println,
                () -> log.info("empty message"));
    }
}