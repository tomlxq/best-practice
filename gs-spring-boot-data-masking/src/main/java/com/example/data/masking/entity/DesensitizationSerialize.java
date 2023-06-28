package com.example.data.masking.entity;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * @Description: DesensitizationSerialize
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 11:37
 * @Version: V1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class DesensitizationSerialize extends JsonSerializer<String> implements ContextualSerializer {
    private DesensitizationTypeEnum type;

    private Integer startInclude;

    private Integer endExclude;
    final Map<DesensitizationTypeEnum, Function<String, String>> map = new HashMap<>();

    {
        map.putAll(ImmutableMap.of(// 自定义类型脱敏
                DesensitizationTypeEnum.CUSTOMER, str -> CharSequenceUtil.hide(str, startInclude, endExclude),
                // userId脱敏
                DesensitizationTypeEnum.USER_ID, str -> String.valueOf(DesensitizedUtil.userId()),
                // 中文姓名脱敏
                DesensitizationTypeEnum.CHINESE_NAME, str -> DesensitizedUtil.chineseName(str),
                // 身份证脱敏
                DesensitizationTypeEnum.ID_CARD, str -> DesensitizedUtil.idCardNum(str, 1, 2),
                // 固定电话脱敏
                DesensitizationTypeEnum.FIXED_PHONE, str -> DesensitizedUtil.fixedPhone(str),
                // 手机号脱敏
                DesensitizationTypeEnum.MOBILE_PHONE, str -> DesensitizedUtil.mobilePhone(str),
                // 地址脱敏
                DesensitizationTypeEnum.ADDRESS, str -> DesensitizedUtil.address(str, 8),
                // 邮箱脱敏
                DesensitizationTypeEnum.EMAIL, str -> DesensitizedUtil.email(str),
                // 密码脱敏
                DesensitizationTypeEnum.PASSWORD, str -> DesensitizedUtil.password(str),
                // 中国车牌脱敏
                DesensitizationTypeEnum.CAR_LICENSE, str -> DesensitizedUtil.carLicense(str)
        ));
        // 银行卡脱敏
        map.put(DesensitizationTypeEnum.BANK_CARD, str -> DesensitizedUtil.bankCard(String.valueOf(str)));
    }

    @Override
    public void serialize(String str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Optional.ofNullable(map.get(type)).ifPresent(p -> {
            try {
                jsonGenerator.writeString(p.apply(str));
            } catch (IOException e) {
                log.error("error", e);
            }
        });
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        if (Objects.isNull(beanProperty)) {
            return serializerProvider.findNullValueSerializer(null);
        }
        // 判断数据类型是否为String类型
        if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
            // 获取定义的注解
            Desensitization desensitization =
                    Optional.ofNullable(beanProperty.getAnnotation(Desensitization.class))
                            .orElse(beanProperty.getContextAnnotation(Desensitization.class));
            // 不为null
            if (Objects.nonNull(desensitization)) {
                // 创建定义的序列化类的实例并且返回，入参为注解定义的type,开始位置，结束位置。
                return new DesensitizationSerialize(desensitization.type(), desensitization.startInclude(),
                        desensitization.endExclude());
            }
        }
        return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
    }
}