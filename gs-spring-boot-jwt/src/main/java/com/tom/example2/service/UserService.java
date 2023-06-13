package com.tom.example2.service;

import com.tom.example2.model.LoginUserVO;
import com.tom.example2.model.UpdatePasswordUserVO;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */

public interface UserService {

    String login(LoginUserVO loginUserVO);

    boolean loginOut(String id);

    String updatePassword(UpdatePasswordUserVO updatePasswordUserVO);
}
