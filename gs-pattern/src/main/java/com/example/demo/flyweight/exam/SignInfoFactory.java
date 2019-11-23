package com.example.demo.flyweight.exam;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/4
 */
public class SignInfoFactory {
    private static HashMap<String, SignInfo> map = new HashMap<>();

    @Deprecated
    public static SignInfo getSignInfo() {
        return new SignInfo();
    }

    public static SignInfo getSignInfo(String key) {
        SignInfo signInfo = null;
        if (map.containsKey(key)) {
            signInfo = map.get(key);
            System.out.println(key + "---直接从池中取得");
        } else {
            signInfo = new SignInfoPool(key);
            map.put(key, signInfo);
            System.out.println(key + "----建立对象，并放置到池中");
        }
        return signInfo;
    }
}
