package com.example.locking;

/**
 * 锁粗化
 *
 * @author TomLuo
 * @date 2023年05月21日 22:47
 */
public class LockCoarseningTest {
    public String test() {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 100; i++) {
            sb.append("test");
        }
        return sb.toString();
    }
}