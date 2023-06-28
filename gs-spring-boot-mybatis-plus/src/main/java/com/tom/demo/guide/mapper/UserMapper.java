package com.tom.demo.guide.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.demo.guide.pojo.User;

/**
 * 在对应的Mapper上面继承基本的类 BaseMapper
 *
 * @author TomLuo
 * @date 2023年03月05日 18:03
 */
public interface UserMapper extends BaseMapper<User> {
    /*所有的CRUD已经编写完成*/

    //写@Repository注解，需要在主类添加MapperScan扫描mapper包
//写@Mapper则不需要

}