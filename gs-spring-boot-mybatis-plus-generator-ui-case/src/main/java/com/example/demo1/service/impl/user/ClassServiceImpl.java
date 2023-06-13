package com.example.demo1.service.impl.user;

import com.example.entity.user.Class;
import com.example.mapper.user.ClassMapper;
import com.example.demo1.service.user.ClassService;
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
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

}
