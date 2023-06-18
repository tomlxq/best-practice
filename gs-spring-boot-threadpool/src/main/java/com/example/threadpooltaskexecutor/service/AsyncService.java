package com.example.threadpooltaskexecutor.service;

import com.example.threadpooltaskexecutor.entity.Student;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: AsyncService
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 5:38
 * @Version: V1.0
 */

public interface AsyncService {
    //1、自定义asyncServiceExecutor线程池
    void executeAsync(List<Student> students,
                      StudentService studentService,
                      CountDownLatch countDownLatch);
}
