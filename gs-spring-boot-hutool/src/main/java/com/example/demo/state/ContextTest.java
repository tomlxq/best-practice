package com.example.demo.state;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/22
 */
public class ContextTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(Context.CLOSE_STATE);
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
