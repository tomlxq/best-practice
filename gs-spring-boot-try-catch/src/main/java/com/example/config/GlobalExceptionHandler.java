package com.example.config;

/**
 * 全局异常处理类 GlobalExceptionHandler
 *
 * @author TomLuo
 * @date 2023年03月06日 20:12
 */

import com.example.entity.AjaxResult;
import com.example.entity.BusinessException;
import com.example.entity.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler
{
    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = BusinessException.class)
    public AjaxResult bizExceptionHandler(BusinessException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.defineError(e);
    }

    /**
     *            处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    public AjaxResult exceptionHandler( Exception e) {
        log.error(e.getMessage(), e);
        return AjaxResult.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);

    }

}