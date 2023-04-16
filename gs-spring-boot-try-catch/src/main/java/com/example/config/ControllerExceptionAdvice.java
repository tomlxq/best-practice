package com.example.config;

import com.example.entity.ResultCode;
import com.example.entity.ResultVo;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 注解@ControllerAdvice，该注解可以把异常处理器应用到所有控制器，而不是单个控制器。
 * 借助该注解，我们可以实现：在独立的某个地方，比如单独一个类，定义一套对各种异常的处理机制，
 * 然后在类的签名加上注解@ControllerAdvice，统一对
 * 不同阶段的、不同异常 进行处理。这就是统一异常处理的原理
 *
 * @author TomLuo
 * @date 2023年04月06日 0:31
 */
@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler({BindException.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVo(ResultCode.VALIDATE_ERROR, objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResultVo APIExceptionHandler(APIException e) {
        // log.error(e.getMessage(), e); 由于还没集成日志框架，暂且放着，写上TODO
        return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
    }
}