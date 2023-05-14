package com.tom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.entities.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper
 *
 * @author TomLuo
 * @date 2023年05月14日 9:41
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
