package com.tom.service;

import com.alibaba.fastjson.JSON;
import com.tom.dto.LoginRequest;
import com.tom.dto.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/1
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("登陆请求参数："+ JSON.toJSONString(loginRequest));
        LoginResponse response = new LoginResponse("0000000", "用户登陆成功");
        return response;
    }
}
