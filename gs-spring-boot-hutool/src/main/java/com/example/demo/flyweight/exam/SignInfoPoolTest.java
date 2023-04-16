package com.example.demo.flyweight.exam;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/4
 */
@Slf4j
public class SignInfoPoolTest {
    public static void main(String[] args) {

//初始化对象池
        for (int i = 0; i < 4; i++) {
            String subject = "科目" + i;
//初始化地址
            for (int j = 0; j < 30; j++) {
                String key = subject + "考试地点" + j;
                SignInfoFactory.getSignInfo(key);
            }
        }
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");
        log.info(JSON.toJSONString(signInfo, true));
    }
}
