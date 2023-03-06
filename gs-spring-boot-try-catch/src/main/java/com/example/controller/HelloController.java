package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.entity.ErrorEnum.NO_PERMISSION;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/18
 */
@RestController
@Slf4j
public class HelloController {
    @GetMapping("/exp")
    public String exp() {
        throw new BusinessException(NO_PERMISSION.getErrorCode(), NO_PERMISSION.getErrorMsg());
    }

    @Autowired
    private ApplicationArguments args;


    @GetMapping("/hello")
    public String hello() {
        return JSON.toJSONString(args.getNonOptionArgs());
    }

}
