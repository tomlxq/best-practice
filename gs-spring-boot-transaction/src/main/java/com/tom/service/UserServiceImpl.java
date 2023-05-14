package com.tom.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tom.entities.User;
import com.tom.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author TomLuo
 * @date 2023年05月14日 8:26
 */


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}