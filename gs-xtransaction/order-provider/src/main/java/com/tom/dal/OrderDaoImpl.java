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
public class OrderDaoImpl implements OrderDao {
    @Autowired
    JdbcTemplate orderJdbcTemplate;

    @Override
    public void save() {
        orderJdbcTemplate.execute("INSERT INTO `order` (`status`,price,order_time) VALUES(1,10,now())");
    }
}
