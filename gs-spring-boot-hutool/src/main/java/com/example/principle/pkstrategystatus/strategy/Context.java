package com.example.principle.pkstrategystatus.strategy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class Context {
    private WorkAlgorithm workMethod;

    public WorkAlgorithm getWork() {
        return workMethod;
    }

    public void setWork(WorkAlgorithm work) {
        this.workMethod = work;
    }

    //每个算法都有必须具有的功能
    public void work() {
        workMethod.work();
    }
}