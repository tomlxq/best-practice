package com.tom.example2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.example2.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserMapper
 *
 * @author TomLuo
 * @date 2023年03月01日 21:13
 */
@Mapper
@Transactional(rollbackFor = Exception.class)
public interface UserMapper extends BaseMapper<User> {
}
