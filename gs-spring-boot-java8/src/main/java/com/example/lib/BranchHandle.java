package com.example.lib;

/**
 * BranchHandle 分支处理接口
 *
 * @author TomLuo
 * @date 2023年03月11日 23:42
 */
@FunctionalInterface
public interface BranchHandle {

    /**
     * 分支操作
     *
     * @param trueHandle  为true时要进行的操作
     * @param falseHandle 为false时要进行的操作
     * @return void
     **/
    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);
}