package com.example.demo.facade;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class HomeTheatreFacadeTest {
    public static void main(String[] args) {
        HomeTheatreFacade homeTheatre = new HomeTheatreFacade();
        System.out.println("~~~~~~~~~~~~准备工作~~~~~~~~~~~~");
        homeTheatre.read();
        System.out.println("~~~~~~~~~~~~正式观影~~~~~~~~~~~~");
        homeTheatre.play();
        System.out.println("~~~~~~~~~~~~观影结束~~~~~~~~~~~~");
        homeTheatre.shutdown();
    }
}
