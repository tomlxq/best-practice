package com.example.goodcontroller;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类
 * 有些时候 JSR303 标准中提供的校验规则不满足复杂的业务需求，也可以自定义校验规则。
 * 自定义校验规则需要做两件事情：
 * 自定义注解类，定义错误信息和一些其他需要的内容
 * 注解校验器，定义判定规则
 *
 * @author TomLuo
 * @date 2023年03月24日 6:27
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MobileValidator.class)
public @interface Mobile {
    /**
     * 是否允许为空
     */
    boolean required() default true;

    /**
     * 校验不通过返回的提示信息
     */
    String message() default "不是一个手机号码格式";

    /**
     * Constraint要求的属性，用于分组校验和扩展，留空就好
     */
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}