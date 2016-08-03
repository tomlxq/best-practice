package pizzs_store_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tom on 2016/6/6.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)//只有类可以被@Factory注解
public @interface Factory {

    /**
     * 工厂的名字
     */
    Class type();

    /**
     * 用来表示生成哪个对象的唯一id
     */
    String id();
}
