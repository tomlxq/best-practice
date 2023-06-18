package com.example.threadpooltaskexecutor;

import com.example.threadpooltaskexecutor.entity.Student;
import com.example.threadpooltaskexecutor.service.AsyncService;
import com.example.threadpooltaskexecutor.service.StudentService;
import com.example.threadpooltaskexecutor.utils.SplitListUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;


@SpringBootApplication(scanBasePackages = "com.example.threadpooltaskexecutor")
@Slf4j
@RequiredArgsConstructor
public class GsSpringBootThreadPoolApplication implements CommandLineRunner {
    private final AsyncService asyncService;
    private final StudentService studentService;

    public static void main(String[] args) {
        args = new String[]{"--spring.config.location=classpath:thread-pool-task-executor/application.yml"};
        SpringApplication.run(GsSpringBootThreadPoolApplication.class, args);

    }
    public int batchInsertWay() throws Exception {
        log.info("开始批量操作.........");
        Random rand = new Random();
        List<Student> list = new ArrayList<>();
        //造100万条数据
        for (int i = 0; i < 1000000; i++) {
            Student student=new Student();
            student.setStudentName("大明："+i);
            student.setAddr("上海:"+rand.nextInt(9) * 1000);
            student.setAge(rand.nextInt(1000));
            student.setPhone("134"+rand.nextInt(9) * 1000);
            list.add(student);
        }
        //2、开始多线程异步批量导入
        long startTime = System.currentTimeMillis(); // 开始时间
        List<List<Student>> list1= SplitListUtils.pagingList(list,100);  //拆分集合
        CountDownLatch countDownLatch = new CountDownLatch(list1.size());
        for (List<Student> list2 : list1) {
            asyncService.executeAsync(list2,studentService,countDownLatch);
        }
        try {
            countDownLatch.await(); //保证之前的所有的线程都执行完成，才会走下面的；
            long endTime = System.currentTimeMillis(); //结束时间
            log.info("一共耗时time: " + (endTime - startTime) / 1000 + " s");
            // 这样就可以在下面拿到所有线程执行完的集合结果
        } catch (Exception e) {
            log.error("阻塞异常:"+e.getMessage());
        }
        return list.size();

    }
    @Override
    public void run(String... args) throws Exception {
        batchInsertWay();
    }
}
