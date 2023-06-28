package com.example.data.masking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 如何使用 hutool 工具类进行数据脱敏。
 如何使用 @JsonSerialize 注解实现自定义序列化。
 如何使用 hutool 工具+Jackson 实现自己的脱敏注解。
 */
@SpringBootApplication
public class GsSpringBootDataMaskingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsSpringBootDataMaskingApplication.class, args);
	}

}
