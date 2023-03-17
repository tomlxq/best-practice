package com.example.ifelse;

/**
 * TakeOrderStrategy 其次针对每个判断条件创建一个实现类
 *
 * @author TomLuo
 * @date 2023年03月16日 0:18
 */

public class TakeOrderStrategy implements OrderStrategy {

    @Override
    public Integer getType() {
        return 1;
    }

    @Override
    public Boolean handler(Object params) {
        // TODO 复杂的处理逻辑
        System.out.println("订单未接单");
        return true;
    }
}