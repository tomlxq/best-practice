package com.example.ifelse;

/**
 * SendOrderStrategy 其次针对每个判断条件创建一个实现类
 *
 * @author TomLuo
 * @date 2023年03月16日 0:17
 */
public class SendOrderStrategy implements OrderStrategy {

    @Override
    public Integer getType() {
        return 2;
    }

    @Override
    public Boolean handler(Object params) {
        // TODO 复杂的处理逻辑
        System.out.println("订单未发货");
        return true;
    }
}


