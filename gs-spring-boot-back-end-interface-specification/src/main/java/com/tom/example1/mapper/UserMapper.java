package com.tom.example1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.example1.domain.User;
import org.mapstruct.Mapper;

/**
 * xx
 *
 * @author TomLuo
 * @date 2023年05月16日 6:07
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}