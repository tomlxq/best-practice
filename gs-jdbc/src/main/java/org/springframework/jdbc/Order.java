package org.springframework.jdbc;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/15
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * sql排序组件
 * @author Tom
 */
@Data
@AllArgsConstructor
public class Order {
    private String propertyName; //哪个字段升序，哪个字段降序
    private boolean ascending; //升序还是降序
    /**
     * Ascending order
     *
     * @param propertyName
     * @return Order
     */
    public static Order asc(String propertyName) {
        return new Order(propertyName, true);
    }

    /**
     * Descending order
     *
     * @param propertyName
     * @return Order
     */
    public static Order desc(String propertyName) {
        return new Order(propertyName, false);
    }
}
