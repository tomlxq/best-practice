package com.tom.demo.service.impl;

import com.tom.demo.pojo.User;
import com.tom.demo.mapper.UserMapper;
import com.tom.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TomLuo
 * @since 2023-03-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
