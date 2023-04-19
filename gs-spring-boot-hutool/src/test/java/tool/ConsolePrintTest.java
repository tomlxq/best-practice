package tool;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

/**
 * 控制台打印封装
 * 一般情况下，我们打印信息到控制台小伙伴们应该再熟悉不过了！
 * <p>
 * System.out.println("Hello World");
 * 但是，这种方式不满足很多场景的需要：
 * <p>
 * 不支持参数，对象打印需要拼接字符串
 * 不能直接打印数组，需要手动调用Arrays.toString
 * 为此，Hutool 封装了Console对象。Console对象的使用更加类似于 Javascript 的console.log()方法，这也是借鉴了 JS 的一个语法糖。
 *
 * @author TomLuo
 * @date 2023年04月18日 6:09
 */
public class ConsolePrintTest {
    @Test
    void name() {

        String[] a = {"java", "c++", "c"};
        Console.log(a);//控制台输出：[java, c++, c]

        Console.log("This is Console log for {}.", "test");//控制台输出：This is Console log for test.
    }
}