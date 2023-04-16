package com.example.demo.chain.women;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/1
 */
public class WomenTest {
    public static void main(String[] args) {
        Handler fatherHandler = new Father();
        Handler sonHandler = new Son();
        Handler husbandHandler = new Husband();
        fatherHandler.setNextHandler(husbandHandler);
        husbandHandler.setNextHandler(sonHandler);
        sonHandler.setNextHandler(fatherHandler);
        fatherHandler.processRequest(new Women(IWomen.Type.Married.name()));
        fatherHandler.processRequest(new Women(IWomen.Type.Not_Married.name()));
        fatherHandler.processRequest(new Women(IWomen.Type.Only_Son.name()));
    }
}
