package com.example;

/**
 * CommonUtils
 *
 * @author TomLuo
 * @date 2023年06月04日 21:56
 */
public class CommonUtils {
    private static final int TIMESTAMP_DIGITS = 13;

    /**
     * 计算timestamp的校验位
     */
    public static int calculateCheckDigit(long timestamp) {
        int sum = 0;
        for (int i = 0; i < TIMESTAMP_DIGITS - 1; i++) {
            char c = String.valueOf(timestamp).charAt(i);
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum % 10;
    }
}