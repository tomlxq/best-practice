package com.example.ifelse;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OrderStrategyFactory 创建一个策略工厂类，承装实现类
 *
 * @author TomLuo
 * @date 2023年03月16日 0:20
 */
@Component
@AllArgsConstructor
public class OrderStrategyFactory {

    private final List<OrderStrategy> orderStrategyList;
    private static Map<Integer, OrderStrategy> strategyMap = new HashMap<>();

    @PostConstruct
    private void init() {
        for (OrderStrategy orderStrategy : orderStrategyList) {
            strategyMap.put(orderStrategy.getType(), orderStrategy);
        }
    }

    /**
     * 执行方法
     *
     * @param status
     * @param params
     * @return
     */
    public Boolean handler(Integer status, Object params) {
        return strategyMap.get(status).handler(params);
    }

}