package com.example.demo.strategy;

/**
 * 封装角色
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class Context  {
    Strategy work;
    public Context(Strategy work){
        this.work= work;
    }
    public void goToOffice(){
        work.goToWork();
    }
}
