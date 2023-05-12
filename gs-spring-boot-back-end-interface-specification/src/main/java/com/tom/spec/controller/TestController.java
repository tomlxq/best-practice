package com.tom.spec.controller;

import com.tom.domain.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月13日 5:14
 */
@RestController
@ApiVersion
@RequestMapping(value = "/{version}/test")
public class TestController {

    @GetMapping(value = "one")
    public String query(){
        return "test api default";
    }

    @GetMapping(value = "one")
    @ApiVersion("1.1")
    public String query2(){
        return "test api v1.1";
    }


    @GetMapping(value = "one")
    @ApiVersion("3.1")
    public String query3(){
        return "test api v3.1";
    }
}