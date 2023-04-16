package com.example.principle.pkmediatorfacade.facade;

import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Tax {
    //收取多少税金
    public int getTax() {
//交纳一个随机数量的税金
        return (new Random()).nextInt(300);
    }
}
