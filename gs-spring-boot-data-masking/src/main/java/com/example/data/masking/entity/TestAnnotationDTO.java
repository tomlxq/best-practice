package com.example.data.masking.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: QQ
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 11:41
 * @Version: V1.0
 */

@Data
public class TestAnnotationDTO implements Serializable {
    /**
     * 自定义
     */
    @Desensitization(type = DesensitizationTypeEnum.CUSTOMER,startInclude = 5,endExclude = 10)
    private String custom;
    /**
     * 手机号
     */
    @Desensitization(type = DesensitizationTypeEnum.MOBILE_PHONE)
    private String phone;
    /**
     * 邮箱
     */
    @Desensitization(type = DesensitizationTypeEnum.EMAIL)
    private String email;
    /**
     * 身份证
     */
    @Desensitization(type = DesensitizationTypeEnum.ID_CARD)
    private String idCard;
}