package com.tom.mapper;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2021/1/10
 */


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassMapper {

    public int updateClassName(@Param("name") String className, @Param("id") int id);
}
