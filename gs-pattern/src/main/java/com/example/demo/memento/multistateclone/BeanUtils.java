package com.example.demo.memento.multistateclone;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class BeanUtils {
    /**
     * 把发起人的所有属性值转换到HashMap中，方便备忘录角色存储
     *
     * @param bean
     * @return
     */
    public static HashMap backProp(Originator bean) {
        HashMap stateMap = new HashMap(16);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            Arrays.stream(propertyDescriptors).forEach(pd -> {
                String name = pd.getName();
                if (name.equalsIgnoreCase("class")) {
                    return;
                }
                Method readMethod = pd.getReadMethod();
                try {
                    Object value = readMethod.invoke(bean, new Object[]{});
                    stateMap.put(name, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            });
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return stateMap;
    }

    /**
     * 把HashMap中的值返回到发起人角色中
     *
     * @param bean
     * @param stateMap
     */
    public static void restoreProp(Originator bean, HashMap stateMap) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            Arrays.stream(propertyDescriptors).forEach(pd -> {
                String name = pd.getName();
                if (!stateMap.containsKey(name)) {
                    return;
                }
                Method writeMethod = pd.getWriteMethod();
                try {
                    writeMethod.invoke(bean, new Object[]{stateMap.get(name)});
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
