package com.tom.lock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * LockAppTest
 *
 * @author TomLuo
 * @date 2023年06月13日 21:14
 */


//@RunWith(SpringRunner.class)
@SpringBootTest(classes = LockApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LockAppTest {
    @Test
    public void test() {
        String url = "http://localhost:8080/welcome";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }
}

