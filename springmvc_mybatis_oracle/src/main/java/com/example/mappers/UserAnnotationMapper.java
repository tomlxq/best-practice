package com.example.mappers;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by tom on 2016/5/21.
 */
public interface UserAnnotationMapper
{

    @Insert("insert into t_user(name,email) values(#{name},#{email})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    void insertUser(User user);

    @Select("select id, name, email from t_user WHERE id=#{id}")
    User findUserById(String id);

    @Select("select id, name, email from t_user")
    List<User> findAllUsers();

}