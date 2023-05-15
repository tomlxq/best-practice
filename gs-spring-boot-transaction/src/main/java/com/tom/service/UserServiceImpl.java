package com.tom.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tom.entities.User;
import com.tom.enums.SexEnum;
import com.tom.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl
 *
 * @author TomLuo
 * @date 2023年05月14日 8:26
 */


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void createUser1() {
        User userPO = new User();
        userPO.setRealName("baiyanEventTest");
        userPO.setNickname("柏炎事务测试");
        userPO.setSex(SexEnum.MAN);
        userPO.setVersion(1);
        save(userPO);
    }
    @Override
    @Transactional
    public void createUser2() {
        User userPO = new User();
        userPO.setRealName("baiyanEventTest");
        userPO.setNickname("柏炎事务测试");
        userPO.setSex(SexEnum.MAN);
        userPO.setVersion(1);
        save(userPO);
    }

}