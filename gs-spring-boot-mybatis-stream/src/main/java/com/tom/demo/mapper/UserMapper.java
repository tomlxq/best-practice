package com.tom.demo.mapper;

import com.tom.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

/**
 * FooMapper
 *
 * @author TomLuo
 * @date 2023年03月06日 22:10
 */
@Mapper
public interface UserMapper {
    @Select("select * from user limit #{limit}")
    Cursor<User> scan(@Param("limit") int limit);
}