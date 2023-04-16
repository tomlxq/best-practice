package com.example.demo.singleton.emperor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class EmperorTest {
    public static void main(String[] args) {
        doFiveTimes(new Runnable() {
            @Override
            public void run() {
                Emperor8.INSTANCE.say();
                //Emperor7 instance= Emperor7.getInstance();
                //instance.say();
            }
        });
    }

    private static void doFiveTimes(Runnable runnable) {
        for (int idx = 0; idx < 5; idx++) {
            runnable.run();
        }
    }

}
