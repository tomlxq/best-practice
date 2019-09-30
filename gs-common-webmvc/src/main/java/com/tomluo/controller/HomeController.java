package com.tomluo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/22
 */
@Controller
public class HomeController {
    @RequestMapping
    public ModelAndView index(@RequestParam String name) {
        Map model = new HashMap<>();
        model.put("name",name);
        return new ModelAndView("index", model);
    }
}
