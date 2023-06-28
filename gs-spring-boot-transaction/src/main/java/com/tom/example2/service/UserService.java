package com.tom.example2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tom.entities.User;

/**
 * UserService
 *
 * @author TomLuo
 * @date 2023年05月14日 8:25
 */
public interface UserService extends IService<User> {

    void createUser1();

    void createUser2();
}