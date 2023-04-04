package com.example.order;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertEquals;

/**
 * TestOrder
 *
 * @author TomLuo
 * @date 2023年03月23日 23:50
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
public class AlphanumericOrderUnitTest {
    private static StringBuilder output = new StringBuilder("");

    @Test
    void myATest() {
        output.append("A");
    }

    @Test
    void myBTest() {
        output.append("B");
    }

    @Test
    void myaTest() {
        output.append("a");
    }

    @AfterAll
    public static void assertOutput() {
        assertEquals("ABa", output.toString());
    }
}
