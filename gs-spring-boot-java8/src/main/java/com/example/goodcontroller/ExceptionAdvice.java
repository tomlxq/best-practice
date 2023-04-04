package com.example.goodcontroller;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 统一拦截异常
 * 自定义异常与统一拦截异常
 * 原来的代码中可以看到有几个问题：
 *
 * 抛出的异常不够具体，只是简单地把错误信息放到了 Exception 中
 * 抛出异常后，Controller 不能具体地根据异常做出反馈
 * 虽然做了参数自动校验，但是异常返回结构和正常返回结构不一致
 * 自定义异常是为了后面统一拦截异常时，对业务中的异常有更加细颗粒度的区分，拦截时针对不同的异常作出不同的响应。
 *
 * 而统一拦截异常的目的一个是为了可以与前面定义下来的统一包装返回结构能对应上，另一个是我们希望无论系统发生什么异常，Http 的状态码都要是 200 ，尽可能由业务来区分系统的异常。
 *
 * @author TomLuo
 * @date 2023年03月24日 6:40
 */
@RestControllerAdvice(basePackages = "com.example.goodcontroller")
public class ExceptionAdvice {

    /**
     * 捕获 {@code BusinessException} 异常
     */
    @ExceptionHandler({BusinessException.class})
    public Result<?> handleBusinessException(BusinessException ex) {
        return Result.failed(ex.getMessage());
    }

    /**
     * 捕获 {@code ForbiddenException} 异常
     */
    @ExceptionHandler({ForbiddenException.class})
    public Result<?> handleForbiddenException(ForbiddenException ex) {
        return Result.failed(ResultEnum.FORBIDDEN);
    }

    /**
     * {@code @RequestBody} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        if (StringUtils.hasText(msg)) {
            return Result.failed(ResultEnum.VALIDATE_FAILED.getCode(), msg);
        }
        return Result.failed(ResultEnum.VALIDATE_FAILED);
    }

    /**
     * {@code @PathVariable} 和 {@code @RequestParam} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public Result<?> handleConstraintViolationException(ConstraintViolationException ex) {
        if (StringUtils.hasText(ex.getMessage())) {
            return Result.failed(ResultEnum.VALIDATE_FAILED.getCode(), ex.getMessage());
        }
        return Result.failed(ResultEnum.VALIDATE_FAILED);
    }

    /**
     * 顶级异常捕获并统一处理，当其他异常无法处理时候选择使用
     */
    @ExceptionHandler({Exception.class})
    public Result<?> handle(Exception ex) {
        return Result.failed(ex.getMessage());
    }

}