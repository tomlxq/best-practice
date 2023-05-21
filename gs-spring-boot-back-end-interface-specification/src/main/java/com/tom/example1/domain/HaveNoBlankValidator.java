package com.tom.example1.domain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * HaveNoBlankValidator
 *
 * @author TomLuo
 * @date 2023年05月13日 4:41
 */


public class HaveNoBlankValidator implements ConstraintValidator<HaveNoBlank, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // null 不做检验
        if (value == null) {
            return true;
        }
        // 校验失败
        return !value.contains(" ");
        // 校验成功
    }
}