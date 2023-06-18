package com.example.threadpooltaskexecutor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.threadpooltaskexecutor.entity.Student;
import com.example.threadpooltaskexecutor.mapper.StudentMapper;
import com.example.threadpooltaskexecutor.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: StudentServiceImpl
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 5:41
 * @Version: V1.0
 */
@Service
@Slf4j
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, Student> implements StudentService {
   // @Override
    //public void saveBatch(List<Student> students) {

   // }
}