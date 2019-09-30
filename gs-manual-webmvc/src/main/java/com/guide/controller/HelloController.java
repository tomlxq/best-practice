package com.guide.controller;

import com.guide.service.UserService;
import org.springframework.web.annotation.Autowired;
import org.springframework.web.annotation.Controller;
import org.springframework.web.annotation.Qualifier;
import org.springframework.web.annotation.RequestMapping;
import org.springframework.web.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/28
 */
@Controller
@RequestMapping("/hello1")
public class HelloController {
    @Autowired
    @Qualifier("userServiceKK")
    private UserService userService;

    @RequestMapping("/*")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="username",required = false) String name){
        Map map=new HashMap<>();
        map.put("username",name);
        return new ModelAndView("hello",map);
    }
}
