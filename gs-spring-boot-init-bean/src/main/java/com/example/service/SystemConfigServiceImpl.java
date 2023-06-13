package com.example.service;

/**
 * eee
 *
 * @author TomLuo
 * @date 2023年05月30日 6:15
 */

import com.example.mapper.SystemConfigMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统属性服务
 **/
@Service("systemConfigService")
@RequiredArgsConstructor
public class SystemConfigServiceImpl implements SystemConfigService{

    // 访问 db 的 mapper
    private final SystemConfigMapper systemConfigMapper;

    // 存放一些系统配置的缓存 map
    private static Map<String, String> SYS_CONF_CACHE = new HashMap<>(16);

    // 使用构造方法完成依赖注入


    // Bean 的初始化方法，捞取数据库中的数据，放入缓存的 map 中
    @PostConstruct
    public void init() {
        // systemConfigMapper 访问 DB，捞取数据放入缓存的 map 中
        // SYS_CONF_CACHE.put(key, value);
        // ...
    }

    // 对外提供获得系统配置的 static 工具方法
    public static String getSystemConfig(String key) {
        return SYS_CONF_CACHE.get(key);
    }

    // 省略了从 DB 更新缓存的代码
    // ...
}