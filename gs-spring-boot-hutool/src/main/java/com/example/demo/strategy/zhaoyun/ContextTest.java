package com.example.demo.strategy.zhaoyun;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class ContextTest {
    //赵云出场了，他根据诸葛亮给他的交代，依次拆开妙计
    public static void main(String[] args) {
        //刚刚到吴国的时候拆第一个
        System.out.println("---刚刚到吴国的时候拆第一个---");
        Context context=new Context(new BackDoor());
        context.operate();
        //刘备乐不思蜀了，拆第二个了
        System.out.println("---刘备乐不思蜀了，拆第二个了---");
        context=new Context(new GivenGreenLight());
        context.operate();
        //孙权的小兵追来了，咋办？拆第三个
        System.out.println("---孙权的小兵追来了，咋办？拆第三个---");
        context=new Context(new BlockEnemy());
        context.operate();
    }
}
