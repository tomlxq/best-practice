package com.example.data.masking;

import cn.hutool.core.util.DesensitizedUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class GsSpringBootDataMaskingApplicationTests {

	@Test
	void contextLoads() {
		log.info("mobilePhone {}", DesensitizedUtil.mobilePhone("13590788499"));
		log.info("idCardNum {}", DesensitizedUtil.idCardNum("511133202308181416",1,2));
		log.info("password {}", DesensitizedUtil.password("1234snvf!@#"));
	}

}
