package com.example.ifelse;


import com.alibaba.fastjson2.JSON;
import com.example.lib.UserUtils;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.util.Dictionary;
import java.util.Map;

/**
 * 替换If-Else的5种方法
 *
 * @author TomLuo
 * @date 2023年03月15日 23:09
 */
public class TestIfElse {
    /**
     * 1.完全不必要的Else块
     *
     * @param input
     */
    @Deprecated
    public void PerformOperation(int input) {
        if (input > 5) {
            //do something
        } else {
            //do something
        }
    }

    /**
     * 1.完全不必要的Else块 improved
     *
     * @param input
     */
    public void PerformOperationImproved(int input) {
        if (input > 5) {
            //do something
            return;
        }
        //do something
    }

    /**
     * 2.价值分配
     *
     * @param input
     * @return
     */
    @Deprecated
    public static String determineGender(int input) {
        String gender = "";
        if (input == 0) {
            gender = "male";
        } else if (input == 1) {
            gender = "woman";
        } else {
            gender = "unknown";
        }
        return gender;
    }

    /**
     * 2.价值分配 improved
     *
     * @param input
     * @return
     */
    public static String determineGenderImproved(int input) {
        if (input == 0) {
            return "male";
        }
        if (input == 1) {
            return "woman";
        }
        return "unknown";
    }

    /**
     * 3.前提条件检查 input must be 0 or 1
     *
     * @param input
     * @return
     */
    @Deprecated
    public String determineGenderRaw(int input) {
        // continue executing logic
        return null;
    }

    /**
     * 3.前提条件检查 input must be 0 or 1
     *
     * @param input
     * @return
     */
    public String determineGenderRawImproved(int input) {
        Preconditions.checkArgument(input < 0 || input > 1, "input params wrong");
        return input == 0 ? "woman" : "man";
    }

    /**
     * 4.将If-Else转换为字典—完全避免If-Else
     *
     * @param operationName
     */
    @Deprecated
    public void performOp(String operationName) {
        if (operationName.equals("op1")) {
            //something
        } else if (operationName.equals("op2")) {
            //something else
        } else {
            //default path
        }

    }

    /**
     * 4.将If-Else转换为字典—完全避免If-Else improved
     *
     * @param operationName
     */
    public void performOpImproved(String operationName) {
        Map<String, Runnable> dict = Maps.newHashMap();

        dict.put("op1", () -> {
            //something
        });
        dict.put("op2", () -> {
            //something else
        });
        dict.get(operationName).run();
    }

    /**
     * 5.扩展应用程序—完全避免使用If-Else
     *
     * @param user
     * @param formatType
     * @return
     */
    public String printUser(SecurityProperties.User user, String formatType) {
        String result = "";
        if (formatType.equals("json")) {
            result = JSON.toJSONString(user);
        } else if (formatType.equals("plainText")) {
            result = "id:{user:id}\nsum:{user.sum}";
        } else {
            result = "unknow format";
        }
        return result;
    }

    /**
     * 4. 卫语句
     * 我们经常需要在方法前处理各种参数嵌套判断逻辑，如果不满足条件就直接返回了，这种情况更加推荐使用卫语句来处理
     *
     * @param status
     */
    public void before(Integer status) {
        if (status != null) {
            if (status != 0) {
                if (status == 1) {
                    System.out.println("订单未接单");
                }
            }
        }
    }

    public void greater(Integer status) {
        if (status == null) {
            return;
        }
        if (status != 0) {
            return;
        }
        if (status == 1) {
            System.out.println("订单未接单");
        }
    }
}