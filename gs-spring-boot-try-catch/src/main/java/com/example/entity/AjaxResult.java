package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 封装统一返回结果类 AjaxResult 异常处理从此抛弃try与catch
 *
 * @author TomLuo
 * @date 2023年03月06日 20:03
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResult {
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;


    /**
     * 自定义异常返回的结果
     *
     * @param de
     * @return
     */
    public static AjaxResult defineError(BusinessException de) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }

    /**
     * 其他异常处理方法返回的结果
     *
     * @param errorEnum
     * @return
     */
    public static AjaxResult otherError(ErrorEnum errorEnum) {
        AjaxResult result = new AjaxResult();
        result.setMsg(errorEnum.getErrorMsg());
        result.setCode(errorEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }
}