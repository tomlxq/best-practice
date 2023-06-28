package com.tom.example2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.example2.model.UserPO;

/**
 * UserMapper
 *
 * @author TomLuo
 * @date 2023年04月22日 16:55
 */
public interface UserMapper extends BaseMapper<UserPO> {
    UserPO getByUsername(String username);

    UserPO getById(String id);

    int updatePassword(UserPO userPO);
}