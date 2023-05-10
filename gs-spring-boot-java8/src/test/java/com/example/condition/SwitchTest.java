package com.example.condition;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * SwtchTest
 *
 * @author TomLuo
 * @date 2023年04月28日 21:17
 */
@Slf4j
public class SwitchTest {
    /**
     * 方式grantType和领取规则
     * 实现方式：
     * 根据优惠券类型resourceType -> 确定查询哪个数据表
     * 根据编码resourceId -> 到对应的数据表里边查询优惠券的派发方式grantType和领取规则
     * 优惠券有多种类型，分别对应了不同的数据库表：
     * 红包 —— 红包发放规则表
     * 购物券 —— 购物券表
     * QQ会员
     * 外卖会员
     * 实际的优惠券远不止这些，这个需求是要我们写一个业务分派的逻辑
     * 第一个能想到的思路就是if-else或者switch case
     */
    @Test
    void name() {

        String resourceType = "红包";
        switch (resourceType) {
            case "红包":
                // 查询红包的派发方式
                break;
            case "购物券":
                //查询购物券的派发方式
                break;
            case "QQ会员":
                break;
            case "外卖会员":
                break;
            //......
            default:
                log.info("查找不到该优惠券类型resourceType以及对应的派发方式");
                break;
        }
    }

    /**
     * 策略模式
     * 策略模式是把if语句里面的逻辑抽出来写成一个类，如果要修改某个逻辑的话，仅修改一个具体的实现类的逻辑即可，可维护性会好不少。
     * 策略模式在业务逻辑分派的时候还是if-else ，只是说比第一种思路的if-else 更好维护一点。。。
     * <p>
     * 但缺点也明显：
     * 如果 if-else的判断情况很多，那么对应的具体策略实现类也会很多，上边的具体的策略实现类还只是2个，
     * 查询红包发放方式写在类RedPaper里边，购物券写在另一个类Shopping里边；
     * 那资源类型多个QQ会员和外卖会员，不就得再多写两个类？有点麻烦了
     * 没法俯视整个分派的业务逻辑
     */
    @Test
    void name2() {
        String resourceType = "红包";
        switch (resourceType) {
            case "红包":
                String grantType = new Context(new RedPaper()).contextInterface();
                break;
            case "购物券":
                String grantType2 = new Context(new Shopping()).contextInterface();
                break;

            //......
            default:
                log.info("查找不到该优惠券类型resourceType以及对应的派发方式");
                break;
        }
    }
    /**
     * Map+函数式接口
     * 用上了Java8的新特性lambda表达式
     *
     * 判断条件放在key中
     * 对应的业务逻辑放在value中
     * 这样子写的好处是非常直观，能直接看到判断条件对应的业务逻辑
     *
     * 需求：根据优惠券(资源)类型 resourceType 和编码 resourceId 查询派发方式grantType
     */
    @Test
    void name3() {

    }
}