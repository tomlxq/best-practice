package com.tom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TinyId
 *
 * @author TomLuo
 * @date 2023年05月07日 23:32
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class LeafServerApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;
    @Test
    void name() {
       // Long id = TinyId.nextId("test");
       // List<Long> ids = TinyId.nextId("test", 10);
    }
}