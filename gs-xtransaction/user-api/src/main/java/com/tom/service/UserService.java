package com.tom.service;

import com.tom.dto.LoginRequest;
import com.tom.dto.LoginResponse;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/1
 */
public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
}
