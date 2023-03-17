package com.example.ifelse;

/**
 * switch
 * switch方法针对枚举值处理有不错的效果，
 * 比如针对不同的订单状态时要做不同的处理，
 * 因为状态值有限，这时我们就可以直接使用switch来针对不同状态做不同的处理
 * 总结：
 * switch语句适用于判断条件有限且不需要经过复杂的计算，处理语句简单的场景。
 * 如果我们的判断条件需要经过一系列复杂的计算才能得到，或者处理语句逻辑也比较复杂时，
 * 我们就要考虑其他的处理方式了，毕竟在case中书写一大堆处理语句并不算得让人舒适的事情
 *
 * @author TomLuo
 * @date 2023年03月16日 0:11
 */
public class TestIfElseSwitch {
    public void before(Integer status) {
        if (status == 1) {
            System.out.println("订单未接单");
        } else if (status == 2) {
            System.out.println("订单未发货");
        } else if (status == 3) {
            System.out.println("订单未签收");
        } else {
            System.out.println("订单已签收");
        }
    }

    public void greater(Integer status) {
        switch (status) {
            case 1:
                System.out.println("订单未接单");
                break;
            case 2:
                System.out.println("订单未发货");
                break;
            case 3:
                System.out.println("订单未签收");
                break;
            default:
                System.out.println("订单已签收");
        }
    }
}