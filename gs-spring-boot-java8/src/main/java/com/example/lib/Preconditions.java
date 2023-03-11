package com.example.lib;

import org.springframework.util.StringUtils;

/**
 * Preconditions
 *
 * @author TomLuo
 * @date 2023年03月11日 23:30
 */
public class Preconditions {
    /**
     * 如果参数为true抛出异常
     *
     * @param expression
     * @return ThrowExceptionFunction
     **/
    public static ThrowExceptionFunction checkArgument(boolean expression) {

        return (errorMessage) -> {
            if (!expression) {
                throw new RuntimeException(errorMessage);
            }
        };
    }

    /**
     * 参数为true或false时，分别进行不同的操作
     *
     * @param expression
     * @return BranchHandle
     **/
    public static BranchHandle isTureOrFalse(boolean expression) {

        return (trueHandle, falseHandle) -> {
            if (expression) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }

    /**
     * 参数为true或false时，分别进行不同的操作
     *
     * @param str
     * @return isBlankOrNoBlank
     **/
    public static PresentOrElseHandler<?> isBlankOrNoBlank(String str) {

        return (consumer, runnable) -> {
            if (StringUtils.hasLength(str)) {
                runnable.run();
            } else {
                consumer.accept(str);
            }
        };
    }
}