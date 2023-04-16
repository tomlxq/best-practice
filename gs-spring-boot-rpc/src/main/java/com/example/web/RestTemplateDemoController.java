package com.example.web;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年04月07日 6:57
 */
public class RestTemplateDemoController {
    /*
     * @description post方式获取入参，插入数据并发起流程
     * @author lyx
     * @date 2022/8/24 16:07
     * @params
     * @return
     */
    @PostMapping("/submit2")
    public Object insertFinanceCompensation(@RequestBody JSONObject jsonObject) {
        String documentId=jsonObject.get("documentId").toString();
        return task2Service.submit(documentId);
    }
    /*
     * @description 使用restTimeplate调外部接口
     * @author lyx
     * @date 2022/8/24 16:02
     * @params documentId
     * @return String
     */
    public String submit(String documentId){
        String assessToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ4ZGFwYXBwaWQiOiIzNDgxMjU4ODk2OTI2OTY1NzYiLCJleHAiOjE2NjEyMjY5MDgsImlhdCI6MTY2MTIxOTcwOCwieGRhcHRlbmFudGlkIjoiMzAwOTgxNjA1MTE0MDUyNjA5IiwieGRhcHVzZXJpZCI6IjEwMDM0NzY2MzU4MzM1OTc5NTIwMCJ9.fZAO4kJSv2rSH0RBiL1zghdko8Npmu_9ufo6Wex_TI2q9gsiLp7XaW7U9Cu7uewEOaX4DTdpbFmMPvLUtcj_sQ";
        RestTemplate restTemplate = new RestTemplate();
        //创建请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        //此处相当于在Authorization里头添加Bear token参数信息
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + assessToken);
        //此处相当于在header里头添加content-type等参数
        httpHeaders.add(HttpHeaders.CONTENT_TYPE,"application/json");
        Map<String, Object> map = getMap(documentId);
        String jsonStr = JSON.toJSONString(map);
        //创建请求体并添加数据
        HttpEntity<Map> httpEntity = new HttpEntity<Map>(map, httpHeaders);
        String url = "http://39.103.201.110:30661/xdap-open/open/process/v1/submit";
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url,httpEntity,String.class);//此处三个参数分别是请求地址、请求体以及返回参数类型
        return forEntity.toString();
    }
}