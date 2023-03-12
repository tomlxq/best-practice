package com.example.service.impl.user;

import com.example.entity.user.Student;
import com.example.mapper.user.StudentMapper;
import com.example.service.user.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tomLuo
 * @since 2023-03-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
