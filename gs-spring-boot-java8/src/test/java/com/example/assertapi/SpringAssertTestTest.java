package com.example.assertapi;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Collections;


/**
 * SpringAssertTestTest
 *
 * @author TomLuo
 * @date 2023年04月26日 21:41
 */
class SpringAssertTestTest {
    @Test
    void name() {

/**
 *要求参数 object 必须为非空（Not Null），否则抛出异常，不予放行
 * 参数 message 参数用于定制异常信息。
 * void notNull(Object object, String message)
 */
        Assert.notNull(null, "");
/**
 * 要求参数必须空（Null），否则抛出异常，不予『放行』。
 * 和 notNull() 方法断言规则相反
 * void isNull (Object object, String message)
 */
        Assert.isNull(null, "");
/**
 * 要求参数必须为真（True），否则抛出异常，不予『放行』。
 *void isTrue ( boolean expression, String message)
 */


        Assert.isTrue(false, "");
/**
 * 要求参数（List/Set）必须非空（Not Empty），否则抛出异常，不予放行
 * void notEmpty (Collection collection, String message)
 */

        Assert.notEmpty(Collections.EMPTY_MAP, "");
/**
 * 要求参数（String）必须有长度（即，Not Empty），否则抛出异常，不予放行
 * void hasLength (String text, String message)
 */

        Assert.hasLength("", "");
/**
 * 要求参数（String）必须有内容（即，Not Blank），否则抛出异常，不予放行
 * void hasText (String text, String message)
 */

        Assert.hasText("", "");
/**
 * 要求参数是指定类型的实例，否则抛出异常，不予放行
 * void isInstanceOf (Class type, Object obj, String message)
 */

        Assert.isInstanceOf(Exception.class, new RuntimeException(""), "");
/**
 * 要求参数 `subType` 必须是参数 superType 的子类或实现类，否则抛出异常，不予放行
 * void isAssignable (Class superType, Class subType, String message)
 */

        Assert.isAssignable(Exception.class, RuntimeException.class, "");
    }
}