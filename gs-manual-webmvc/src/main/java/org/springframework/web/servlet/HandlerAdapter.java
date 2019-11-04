package org.springframework.web.servlet;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/28
 */
@Data
@AllArgsConstructor
public class HandlerAdapter {
    Map<String, Integer> paramTypes;
    HandlerMapping handler;


    public ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, HandlerExecutionChain handler) {
        Class<?>[] parameterTypes = handler.getMethod().getParameterTypes();
        Map<String, String[]> parameterMap = req.getParameterMap();
        Object[] parameterValues = new Object[parameterTypes.length];
        parameterMap.forEach((key, param) -> {
            String value = Arrays.toString(param).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
            if (!this.paramTypes.containsKey(key)) {
                return;
            }
            Integer idx = this.paramTypes.get(key);
            parameterValues[idx] = castStringValue(value, parameterTypes[idx]);
        });
        if (this.paramTypes.containsKey(HttpServletRequest.class.getName())) {
            Integer idx = this.paramTypes.get(HttpServletRequest.class.getName());
            parameterValues[idx] = req;
        }
        if (this.paramTypes.containsKey(HttpServletResponse.class.getName())) {
            Integer idx = this.paramTypes.get(HttpServletResponse.class.getName());
            parameterValues[idx] = resp;
        }
        try {
            boolean isModelAndView = handler.getMethod().getReturnType()==ModelAndView.class;

            Object invoke = handler.getMethod().invoke(handler.getBean(), parameterValues);
            if(isModelAndView){
                return (ModelAndView)invoke;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object castStringValue(String value, Class<?> parameterType) {
        if (parameterType == String.class) {
            return value;
        } else if (parameterType == int.class) {
            return Integer.valueOf(value).intValue();
        } else if (parameterType == Integer.class) {
            return Integer.valueOf(value);
        } else {
            return value;
        }
    }
}
