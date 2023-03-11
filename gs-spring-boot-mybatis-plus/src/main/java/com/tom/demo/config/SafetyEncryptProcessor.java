package com.tom.demo.config;

import com.baomidou.mybatisplus.core.toolkit.AES;
import com.google.common.collect.Maps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.util.HashMap;

/**
 * xxxx
 *
 * @author TomLuo
 * @date 2023年03月11日 10:55
 */
public class SafetyEncryptProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        //命令行中获取密钥
        String mpwKey = environment.getProperty("mpw.key");

        // 返回全部形式的配置源（环境变量、命令行参数、配置文件 ...）
//        for (PropertySource<?> ps : environment.getPropertySources()) {
//            // 判断是否需要含有加密密码，没有就直接跳过
//            if (ps instanceof SimpleCommandLinePropertySource) {
//                SimpleCommandLinePropertySource source = (SimpleCommandLinePropertySource) ps;
//                mpwKey = source.getProperty("mpw.key");
//                break;
//            }
//        }

        //处理加密内容（获取到原有配置，然后解密放到新的map 里面（key是原有key））
        HashMap<String, Object> map = Maps.newHashMap();
        for (PropertySource<?> ps : environment.getPropertySources()) {
            if (ps instanceof OriginTrackedMapPropertySource) {
                OriginTrackedMapPropertySource source = (OriginTrackedMapPropertySource) ps;
                for (String name : source.getPropertyNames()) {
                    Object value = source.getProperty(name);
                    if (value instanceof String) {
                        String str = (String) value;
                        if (str.startsWith("mpw:")) {
                            map.put(name, AES.decrypt(str.substring(4), mpwKey));
                        }
                    }
                }
            }
        }
        // 将解密的数据放入环境变量，并处于第一优先级上 (这里一定要注意，覆盖其他配置)
        if (!map.isEmpty()) {
            environment.getPropertySources().addFirst(new MapPropertySource("custom-encrypt", map));
        }
    }
}