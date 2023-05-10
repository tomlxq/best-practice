package com.example;


import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Slf4j
public class GsWebixApplicationTests {

    /**
     * dateformat 优先级
     */
    @Test
    public void contextLoads() throws JsonProcessingException {
            TestFastJson testFastJson=new TestFastJson();
        testFastJson.setId("1");
        testFastJson.setName("test");
        testFastJson.setGender("male");
        testFastJson.setPhone("123");
       log.info("{}", JSONObject.toJSONString(testFastJson));

        TestJackson testJackson=new TestJackson();
        testJackson.setId("1");
        testJackson.setName("test");
        testJackson.setGender("male");
        testJackson.setPhone("123");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        log.info("{}",  objectMapper.writeValueAsString(testJackson));
    }
    /**
     * $ref 循环引用问题
     */


}
