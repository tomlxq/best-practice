package com.example.ifelse;

/**
 * 3. 策略模式
 * 上述的函数式接口的形式，实际上是针对方法进行了分离，所有的实现方法还是放在了一个类里，
 * 即使你可以在 FunctionInterfaceStrategy 类中通过依赖注入的形式再次调用其他类的方法，
 * 但是这样的模式，已经趋近于我们要将的下一种方法，即使用策略模式来解决 if else
 * 策略模式的形式适用于实现方法更加复杂的情况，需要将处理逻辑解耦的更加干净的场景
 * 总结：
 * 通过上述的代码示例，大家其实可以发现，函数式接口和策略模式有异曲同工之处，
 * 根本区别在于是否需要将实现方法单独抽取为一个实现类。抽取的粒度越细也就说明解耦越强
 * 使用策略模式，后续如果需要增加if else条件的话，只需要增加实现类即可，针对后续的处理更加方便
 *
 * 创建一个接口类，用来规定我们后续的实现类的格式
 *
 *
 * @author TomLuo
 * @date 2023年03月16日 0:16
 */
public interface  OrderStrategy  {

    /**
     * 获取实现类标识
     * @return
     */
    Integer getType();    /**
     * 逻辑处理
     * @param params
     * @return
     */
    Boolean handler(Object params);

}