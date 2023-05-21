package com.example;

import cn.hutool.core.util.IdcardUtil;
import com.example.domain.Country;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * OptionTest
 *
 * @author TomLuo
 * @date 2023年05月21日 22:10
 */
@Slf4j
public class OptionTest {
    @Test
    void name() {
        // 判断行政区是否为空
        Country country=new Country();
        String name= getName(country);
        String name2= getName2(country);
    }

    private static String getName(Country country) {

        if(country != null){
            // 判断行政区的上一级，行政城市是否为空
            if(country.getCity() != null){
                // 判断行政城市的上一级，行政省是否为空
                if(country.getCity().getProvince() != null){
                    // 获取对应的行政省相关的数据
                    return country.getCity().getProvince();
                }
            }
        }
        return "error";
    }
    private static String getName2(Country country) {
        // 获取当前行政区最顶级的省信息名称
        String result = Optional.ofNullable(country)
                .map(Country::getCity)
                .map(IdcardUtil.Idcard::getProvince)
                .orElse("error");
        return result;
    }

    @Test
    void name2() {
        Optional optional = Optional.empty();
        System.out.println(optional);

        // 非空情况下，会正常返回
        Optional optional2 = Optional.of("hello world");
        System.out.println(optional2);

        // 为空情况下，会抛空指针异常
        Optional optional3 = Optional.of(null);
        System.out.println(optional3);

        // 非空情况下，会正常返回
        Optional optional4 = Optional.ofNullable("hello world");
        System.out.println(optional4);

        // 为空情况下，会返回 empty 对象
        Optional optional5 = Optional.ofNullable(null);
        System.out.println(optional5);

        // 非空值，返回true
        boolean rs1 =  Optional.ofNullable("hello").isPresent();
        System.out.println(rs1);

// 空值，返回false
        boolean rs2 =  Optional.ofNullable(null).isPresent();
        System.out.println(rs2);

        // 非空值，返回当前值
        Object rs =  Optional.ofNullable("hello world").get();
        System.out.println(rs);

        // 空值，会抛出 NoSushElementException 异常
        Object rs3 =  Optional.ofNullable(null).get();
        System.out.println(rs3);

        Optional.ofNullable("hello world")
                .ifPresent( x -> {
                    System.out.println(x);
                });

        Optional.ofNullable("hello world")
                .filter(x -> x.contains("hello"))
                .ifPresent(x -> {
                    System.out.println(x);
                });

        Optional.ofNullable("hello+world")
                .map(t -> {
                    if(t.contains("+")){
                        return t.replace("+", " ");
                    }
                    return t;
                }).ifPresent(t -> {
                    System.out.println(t);
                });

        //flatMap()
        //flatMap 方法与 map 方法类似，唯一不同的地方在于：需要手动将返回的值，包装成Optional实例，并且参数值不允许为空。

        Optional.ofNullable("hello+world")
                .flatMap(t -> {
                    if(t.contains("+")){
                        t =  t.replace("+", " ");
                    }
                    // 不同之处
                    return Optional.of(t);
                }).ifPresent(t -> {
                    System.out.println(t);
                });

        //2.10、orElse()
       //orElse 方法作用是如果实例包含非空值，那么返回当前值；否则返回指定的默认值。
        Object rs4 =  Optional.ofNullable(null).orElse("null");
        System.out.println(rs4);

        //2.11、orElseGet()

       // orElseGet 方法作用是如果实例包含非空值，返回这个值；否则，它会执行作为参数传入的Supplier函数式接口方法，并返回其执行结果。

        Object result = Optional.ofNullable(null)
                .orElseGet(() -> {
                    return "error";
                });
        System.out.println(result);

        //2.12、orElseThrow()
        //orElseThrow 方法作用是如果实例包含非空值，返回这个值；否则，它会执行作为参数传入的异常类。

        Optional.ofNullable(null)
                .orElseThrow(() -> new RuntimeException("参数为空"));
    }
}