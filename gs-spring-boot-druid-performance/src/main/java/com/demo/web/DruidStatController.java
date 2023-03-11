package com.demo.web;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.stat.DruidStatManagerFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/22
 */
@RestController
@Slf4j
@RequestMapping(value = "/druid")
public class DruidStatController {
    @Autowired
    DruidDataSource druidDataSource;
    @GetMapping("/stat")
    public Object druidStat(){
        //stat-view-servlet
        //spring.datasource.druid.stat-view-servlet.enabled
        log.info("info {}",druidDataSource.getVersion());

        // 获取数据源的监控数据
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
