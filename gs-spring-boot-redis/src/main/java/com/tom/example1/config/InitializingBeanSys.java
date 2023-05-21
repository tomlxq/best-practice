package com.tom.example1.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * aaa
 *
 * @author TomLuo
 * @date 2023年03月01日 23:08
 */
@Service
public class InitializingBeanSys implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        System.out.println("执行了UserService的初始化InitializingBean.afterPropertiesSet方法");
    }
}
