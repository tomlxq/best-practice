package com.tom.demo;

import com.baomidou.mybatisplus.core.toolkit.AES;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年03月11日 8:21
 */
@Slf4j
public class RandomKeyTest {
    @Test
    public void createRandomKey() {
        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();
        log.info(randomKey);//7a10eda6bd25ae0c// 随机密钥加密
        String url = AES.encrypt("jdbc:mysql://192.168.238.150:3306/demo?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&serverTimeZone=GMT%2B8", randomKey);
        log.info(url);
        String username = AES.encrypt("root", randomKey);
        log.info(username);
        String pwd = AES.encrypt("root", randomKey);
        log.info(pwd);
    }
}
