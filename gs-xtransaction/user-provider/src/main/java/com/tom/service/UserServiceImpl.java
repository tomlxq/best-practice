package com.tom.service;

import com.alibaba.fastjson.JSON;
import com.tom.dal.UserDao;
import com.tom.dto.LoginRequest;
import com.tom.dto.LoginResponse;
import com.tom.dto.RechargeReq;
import com.tom.dto.RechargeRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/1
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("登陆请求参数：" + JSON.toJSONString(loginRequest));
        LoginResponse response = new LoginResponse("0000000", "用户登陆成功");
        return response;
    }

    @Override
    public RechargeRes recharge(RechargeReq rechargeReq) {
        log.info("调到用户中心 {}", JSON.toJSONString(rechargeReq));
        RechargeRes rechargeRes = new RechargeRes("10000", "更新用户成功");
        userDao.updateUser();
        return rechargeRes;
    }
}
