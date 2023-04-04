package com.example.order;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertEquals;

/**
 * eee
 *
 * @author TomLuo
 * @date 2023年03月23日 23:52
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderAnnotationUnitTest {
    private static StringBuilder output = new StringBuilder("");

    @Test
    @Order(1)
    void firstTest() {
        output.append("a");
    }

    @Test
    @Order(2)
    void secondTest() {
        output.append("b");
    }

    @Test
    @Order(3)
    void thirdTest() {
        output.append("c");
    }

    @AfterAll
    public static void assertOutput() {
        assertEquals("abc", output.toString());
    }
}