package com.tom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tom.entities.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
