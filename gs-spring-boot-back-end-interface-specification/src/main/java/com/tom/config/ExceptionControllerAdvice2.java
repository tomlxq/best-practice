package com.tom.config;

/**
 * ee
 *
 * @author TomLuo
 * @date 2023年05月13日 4:43
 */
import com.tom.domain.APIException;
import com.tom.domain.GlobalMsgEnum;
import com.tom.domain.ResultCode;
import com.tom.domain.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionControllerAdvice2 {
    //自定义的全局异常
    @ExceptionHandler(APIException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO<?> APIExceptionHandler(APIException e) {
        return new ResultVO<>(ResultCode.VALIDATE_FAILED,e);
        //return e.getMsg();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return objectError.getDefaultMessage();
    }

    /**
     * 系统异常 预期以外异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO<?> handleUnexpectedServer(Exception ex) {
        log.error("系统异常：", ex);
        // GlobalMsgEnum.ERROR是我自己定义的枚举类
        return new ResultVO<>(ResultCode.VALIDATE_FAILED,ex);
    }

    /**
     * 所以异常的拦截
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO<?> exception(Throwable ex) {
        log.error("系统异常：", ex);
        return new ResultVO<>(ResultCode.VALIDATE_FAILED,ex);
    }
}