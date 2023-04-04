package com.example.goodcontroller;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 注解校验器
 *
 * @author TomLuo
 * @date 2023年03月24日 6:28
 */
public class MobileValidator implements ConstraintValidator<Mobile, CharSequence> {

    private boolean required = false;

    private final Pattern pattern = Pattern.compile("^1[34578][0-9]{9}$"); // 验证手机号

    /**
     * 在验证开始前调用注解里的方法，从而获取到一些注解里的参数
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(Mobile constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    /**
     * 判断参数是否合法
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     */
    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (this.required) {
            // 验证
            return isMobile(value);
        }
        if (StringUtils.hasText(value)) {
            // 验证
            return isMobile(value);
        }
        return true;
    }

    private boolean isMobile(final CharSequence str) {
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
}