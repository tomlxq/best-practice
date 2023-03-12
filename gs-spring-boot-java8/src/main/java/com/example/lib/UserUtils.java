package com.example.lib;

/**
 * UserUtils
 *
 * @author TomLuo
 * @date 2023年03月12日 4:38
 */
public class UserUtils {
    private static final ThreadLocal<Long> user = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        user.set(userId);
    }

    public static Long getUserId() {
        return user.get();
    }

    public static void clear() {
        user.remove();
    }
}