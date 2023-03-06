package com.tom.web.controller;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author TomLuo
 * @date 2023年03月01日 21:12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{

}