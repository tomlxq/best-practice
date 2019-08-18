package com.tom.web.controller;

import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tom on 2016/5/24.
 */
@Controller
//@Slf4j
public class MessageController {
    @RequestMapping(value = "/message", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject message(@RequestParam String message) {
        //log.("{}", message);
        JSONObject item = new JSONObject();
        item.put("name", "我是tomLuo");
        return item;
    }
}
