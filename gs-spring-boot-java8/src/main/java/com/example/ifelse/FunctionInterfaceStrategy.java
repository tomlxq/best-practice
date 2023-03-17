package com.example.ifelse;

import com.google.common.collect.ImmutableMap;
import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 2. 函数式接口
 * 针对比较复杂的处理逻辑时，我们偏向于将这些处理逻辑单独抽离出来，而不是还放在一个方法里处理，增加整体的可读性和解耦性，也是我们衍生出利用函数式接口来处理if else的模式
 * 函数式接口map处理if else的要义，是将各个条件的复杂处理逻辑单独抽取为一个函数式接口方法，通过统一的判断条件来调用不同的方法
 * @Autowired
 * private FunctionInterfaceStrategy functionInterfaceStrategy;
 * functionInterfaceStrategy.doOperation("参数",1);
 *
 * @author TomLuo
 * @date 2023年03月15日 23:53
 */
public class FunctionInterfaceStrategy {
    /**
     * key 方法参数，多个参数可以自定义一个实体类处理
     * value 方法返回值
     */
    private Map<Integer, Function<Object, Boolean>> operationMap;

    @PostConstruct
    private void init() {
        operationMap = ImmutableMap.of(
                1, this::takeOrder,
                2, this::sendOrder,
                3, this::signOrder,
                4, this::finishOrder);
    }

    public Boolean doOperation(Object params, Integer status) {
        return operationMap.get(status) == null || operationMap.get(status).apply(params);
    }

    private Boolean takeOrder(Object params) {
        // TODO 比较复杂的处理逻辑
        System.out.println("订单未接单");
        return true;
    }

    private Boolean sendOrder(Object params) {
        // TODO 比较复杂的处理逻辑
        System.out.println("订单未发货");
        return true;
    }

    private Boolean signOrder(Object params) {
        // TODO 比较复杂的处理逻辑
        System.out.println("订单未签收");
        return true;
    }

    private Boolean finishOrder(Object params) {
        // TODO 比较复杂的处理逻辑
        System.out.println("订单已签收");
        return true;
    }
}