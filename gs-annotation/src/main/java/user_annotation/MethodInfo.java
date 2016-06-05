package user_annotation;

/**
 * Created by tom on 2016/6/6.
 *
 注解方法不能带有参数；
 注解方法返回值类型限定为：基本类型、String、Enums、Annotation或者是这些类型的数组；
 注解方法可以有默认值；
 注解本身能够包含元注解，元注解被用来注解其它注解。
 */
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo{
    String author() default "Pankaj";
    String date();
    int revision() default 1;
    String comments();
}