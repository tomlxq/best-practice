package com.example.service;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * ww
 *
 * @author TomLuo
 * @date 2023年05月31日 6:26
 */
@Service
@DependsOn({"systemConfigService"})
public class BizService {

    public BizService() {
        String xxValue = SystemConfigServiceImpl.getSystemConfig("xxKey");
        // 可行
    }

}