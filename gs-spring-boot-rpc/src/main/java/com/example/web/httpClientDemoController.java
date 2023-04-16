package com.example.web;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.util.Map;

/**
 * 方式一：使用原始httpClient请求
 *
 * @author TomLuo
 * @date 2023年04月07日 6:47
 */
public class httpClientDemoController {

    /*
     * @description get方式获取入参，插入数据并发起流程
     * @author lyx
     * @date 2022/8/24 16:05
     * @params documentId
     * @return String
     */
//
    @GetMapping("/submit/{documentId}")
    public String submit1(@PathVariable String documentId) throws ParseException {
        //此处将要发送的数据转换为json格式字符串
        Map<String,Object> map =task2Service.getMap(documentId);
        String jsonStr = JSON.toJSONString(map, SerializerFeature.WRITE_MAP_NULL_FEATURES,SerializerFeature.QuoteFieldNames);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONObject sr = task2Service.doPost(jsonObject);
        return sr.toString();
    }
    /*
     * @description 使用原生httpClient调用外部接口
     * @author lyx
     * @date 2022/8/24 16:08
     * @params date
     * @return JSONObject
     */
    public static JSONObject doPost(JSONObject date) {
        String assessToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ4ZGFwYXBwaWQiOiIzNDgxMjU4ODk2OTI2OTY1NzYiLCJleHAiOjE2NjEyMjY5MDgsImlhdCI6MTY2MTIxOTcwOCwieGRhcHRlbmFudGlkIjoiMzAwOTgxNjA1MTE0MDUyNjA5IiwieGRhcHVzZXJpZCI6IjEwMDM0NzY2MzU4MzM1OTc5NTIwMCJ9.fZAO4kJSv2rSH0RBiL1zghdko8Npmu_9ufo6Wex_TI2q9gsiLp7XaW7U9Cu7uewEOaX4DTdpbFmMPvLUtcj_sQ";
        CloseableHttpClient client = HttpClients.createDefault();
        // 要调用的接口url
        String url = "http://39.103.201.110:30661 /xdap-open/open/process/v1/submit";
        HttpPost post = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            //创建请求体并添加数据
            StringEntity s = new StringEntity(date.toString());
            //此处相当于在header里头添加content-type等参数
            s.setContentType("application/json");
            s.setContentEncoding("UTF-8");
            post.setEntity(s);
            //此处相当于在Authorization里头添加Bear token参数信息
            post.addHeader("Authorization", "Bearer " +assessToken);
            HttpResponse res = client.execute(post);
            String response1 = EntityUtils.toString(res.getEntity());
            if (res.getStatusLine()
                    .getStatusCode() == HttpStatus.SC_OK) {
                // 返回json格式：
                String result = EntityUtils.toString(res.getEntity());
                jsonObject = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }
}