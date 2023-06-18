package com.pattern.gsspringbootpattern.strategy.service;

import com.pattern.gsspringbootpattern.config.ContextUtils;

/**
 * @Description: RedPaper
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 10:33
 * @Version: V1.0
 */

public class RedPaper extends Strategy{
    @Override
    public String queryString() {
        return ContextUtils.getBean(GrantTypeService.class).redPaper("红包");
    }
}