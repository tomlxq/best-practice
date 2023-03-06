package com.tom.web.controller;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年03月02日 5:10
 */
public class EnvironmentPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    String randomKey = "bd8526e2b6b6ace8";
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment env = event.getEnvironment();
        MutablePropertySources pss = env.getPropertySources();
        List<PropertySource> list = new ArrayList<>();
        for(PropertySource ps : pss){
            Map<String,Object> map = new HashMap<>();
            if(ps instanceof OriginTrackedMapPropertySource){
                OriginTrackedMapPropertySource propertySource = new OriginTrackedMapPropertySource(ps.getName(),map);
                Map<String,Object> src = (Map<String,Object>)ps.getSource();
                src.forEach((k,v)->{
                    String strValue = String.valueOf(v);
                    if(strValue.startsWith("mpw:")) {
                        // 此处进行截取出对应的密文,然后调用对应的解密算法进行解密操作
                        v = AES.encrypt(strValue, randomKey);
                    }
                    map.put(k,v);
                });
                list.add(propertySource);
            }
        }
        /**
         此处是删除原来的 OriginTrackedMapPropertySource 对象，
         把解密后新生成的放入到 Environment,为什么不直接修改原来的
         OriginTrackedMapPropertySource 对象，此处不做过多解释
         不懂的可以去看看它对应的源码，也算是留一个悬念，也是希望大家
         能够没事多看一看源码。
         */
        list.forEach(ps->{
            pss.remove(ps.getName());
            pss.addLast(ps);
        });
    }
}