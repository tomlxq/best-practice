package com.example.lib;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * UserUtils
 *
 * @author TomLuo
 * @date 2023年03月12日 4:38
 */
public class UserTranUtils {
    private static final TransmittableThreadLocal<Long> user = new TransmittableThreadLocal<>();

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