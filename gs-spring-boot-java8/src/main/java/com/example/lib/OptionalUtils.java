package com.example.lib;

import com.example.entity.CompResult;
import com.example.entity.Competition;
import com.example.entity.User;

import java.util.Optional;

/**
 * OptionalUtils
 *
 * @author TomLuo
 * @date 2023年06月13日 19:34
 */
public class OptionalUtils {
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static String getChampionName(Competition comp) throws IllegalArgumentException {
        if (comp != null) {
            CompResult result = comp.getResult();
            if (result != null) {
                User champion = result.getChampion();
                if (champion != null) {
                    return champion.getName();
                }
            }
        }
        throw new IllegalArgumentException("The value of param comp isn't available.");
    }
    public static String getChampionName2(Competition comp) throws IllegalArgumentException {
        return Optional.ofNullable(comp)
                .map(Competition::getResult)  // 相当于c -> c.getResult()，下同
                .map(CompResult::getChampion)
                .map(User::getName)
                .orElseThrow(()->new IllegalArgumentException("The value of param comp isn't available."));
    }
}