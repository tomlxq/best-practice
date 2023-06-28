package com.example.data.masking.entity;

import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.SneakyThrows;

import java.io.IOException;

/**
 * @Description: TestJacksonSerialize
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 11:28
 * @Version: V1.0
 */

public class TestJacksonSerialize extends JsonSerializer {

    @SneakyThrows
    @Override
    public void serialize(Object str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // 使用我们的hutool工具类进行手机号脱敏
        jsonGenerator.writeString(DesensitizedUtil.fixedPhone(String.valueOf(str)));
    }
}