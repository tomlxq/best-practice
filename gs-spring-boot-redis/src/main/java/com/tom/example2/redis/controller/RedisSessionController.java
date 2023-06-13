package com.tom.example2.redis.controller;



import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
/**
 * session 共享
 *
 * @author TomLuo
 * @date 2023年05月07日 22:09
 */

@RestController
@RequestMapping("session")
public class RedisSessionController {

    /**
     * 设置session的值
     * @param request
     * @return
     */
    @GetMapping("set")
    public Map set(HttpServletRequest request) {
        String id = request.getSession().getId();
        Map<String, String> vas = new HashMap<>();

        String key = "key";
        String value = "value";
        vas.put("id", id);
        vas.put(key, value);
        // 自定义session的值
        request.getSession().setAttribute(key, value);

        return vas;
    }

    /**
     * 获取session的值
     * @param request
     * @return
     */
    @GetMapping("get")
    public Map get(HttpServletRequest request) {
        Map<String, Object> vas = new HashMap<>();

        // 遍历所有的session值
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String k = attributeNames.nextElement();
            Object va = request.getSession().getAttribute(k);
            vas.put(k, va);
        }

        vas.put("id", request.getSession().getId());

        return vas;
    }
}