package com.tom.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tom.mapper.UserMapper;
import com.tom.model.User;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author TomLuo
 * @date 2023年03月01日 21:12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}