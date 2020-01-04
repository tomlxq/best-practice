package com.tom.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/4
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate userJdbcTemplate;

    @Override
    public void updateUser() {
        userJdbcTemplate.execute
                ("update user set name='tom',mobile='1378088888'," +
                        "sex='male' where id=4");
    }
}