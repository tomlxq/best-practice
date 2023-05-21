package com.tom.example1.config;

import com.tom.example1.domain.APIException;
import com.tom.example1.domain.ResultCode;
import com.tom.example1.domain.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ExceptionAdvice
 *
 * @author TomLuo
 * @date 2023年05月11日 6:00
 */
@RestControllerAdvice(basePackages = "com.tom")
public class ExceptionControllerAdvice {
    // 使用form data方式调用接口，校验异常抛出 BindException
// 使用 json 请求体调用接口，校验异常抛出 MethodArgumentNotValidException
// 单个参数校验异常抛出ConstraintViolationException
// 处理 json 请求体调用接口校验失败抛出的异常


    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e) {
        // 注意哦，这里传递的响应码枚举
        return new ResultVO<>(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 注意哦，这里传递的响应码枚举
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

}