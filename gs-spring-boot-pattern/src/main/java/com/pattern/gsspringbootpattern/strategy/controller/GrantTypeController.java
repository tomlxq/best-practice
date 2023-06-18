package com.pattern.gsspringbootpattern.strategy.controller;


import com.pattern.gsspringbootpattern.strategy.service.QueryGrantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xxx
 *
 * @author TomLuo
 * @date 2023年04月28日 21:35
 */
@RestController
public class GrantTypeController {

    @Autowired
    private QueryGrantTypeService queryGrantTypeService;

    @PostMapping("/grantType")
    public String test(String resourceName){
        return queryGrantTypeService.getResult(resourceName);
    }
}