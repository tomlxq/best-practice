package com.tom.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tom on 2016/6/1.
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String jspView() {
        return "hello";
    }

    @RequestMapping("/fm")
    public String freemarkerView() {
        return "fm";
    }

}
