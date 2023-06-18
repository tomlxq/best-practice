package com.example.threadpooltaskexecutor.service.impl;

import com.example.threadpooltaskexecutor.entity.Student;
import com.example.threadpooltaskexecutor.service.AsyncService;
import com.example.threadpooltaskexecutor.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: aaa
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 5:36
 * @Version: V1.0
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    //1、自定义asyncServiceExecutor线程池
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync(List<Student> students,
                             StudentService studentService,
                             CountDownLatch countDownLatch) {
        try{
            log.info("start executeAsync");
            //异步线程要做的事情
            studentService.saveBatch(students);
            log.info("end executeAsync");
        }finally {
            countDownLatch.countDown();// 很关键, 无论上面程序是否异常必须执行countDown,否则await无法释放
        }
    }
}