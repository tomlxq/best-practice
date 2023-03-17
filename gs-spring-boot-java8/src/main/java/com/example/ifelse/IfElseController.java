package com.example.ifelse;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 方法调用
 *
 * @author TomLuo
 * @date 2023年03月16日 0:21
 */
@RestController
@RequestMapping("ifelse")
@AllArgsConstructor
public class IfElseController {

    private final OrderStrategyFactory orderStrategyFactory;
    @GetMapping("strategy")    public Boolean strategy(Integer status){
        return orderStrategyFactory.handler(status,"1");
    }

}