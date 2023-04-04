package com.example.date;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * SimpleDateFormatDemoTest
 *
 * @author TomLuo
 * @date 2023年03月26日 22:37
 */
class SimpleDateFormatDemoTest {

    @Test
    void formatDateWithThreadLocal() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String formattedDate = SimpleDateFormatDemo.formatDateWithThreadLocal(new Date());
                System.out.println(Thread.currentThread().getName() + ": " + formattedDate);
            }).start();
        }
    }

    @Test
    void formatDateWithSynchronized() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String formattedDate = SimpleDateFormatDemo.formatDateWithSynchronized(new Date());
                System.out.println(Thread.currentThread().getName() + ": " + formattedDate);
            }).start();
        }
    }

    @Test
    void formatDateWithDateFormatUtil() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String formattedDate = SimpleDateFormatDemo.formatDateWithDateFormatUtil(new Date());
                System.out.println(Thread.currentThread().getName() + ": " + formattedDate);
            }).start();
        }
    }

    private static final Instant TEST_INSTANT = Instant.parse("2022-10-09T12:34:56.789Z");
    private static final String EXPECTED_FORMATTED_STRING = "2022-10-09 12:34:56";
    private static final String TEST_FORMATTED_STRING = "2022-10-09 12:34:56";

    @Test
    public void testFormatDate() {
        String formattedString = SimpleDateFormatDemo.formatDate(TEST_INSTANT);
        assertEquals(EXPECTED_FORMATTED_STRING, formattedString);
    }

    @Test
    public void testParseDate() {
        Instant parsedInstant = SimpleDateFormatDemo.parseDate(TEST_FORMATTED_STRING);
        assertEquals(TEST_INSTANT, parsedInstant);
    }
}