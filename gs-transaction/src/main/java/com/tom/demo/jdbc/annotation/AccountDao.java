package com.tom.demo.jdbc.annotation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
@Repository
public class AccountDao {

    private JdbcTemplate template;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public void transferOut(String name, double money) throws SQLException {
        int update = template.update("update account set money=money-? where name=? and money>=?", money, name, money);
        if (update <= 0) {
            throw new SQLException("银行账号钱不够，无法转账");
        }
    }

    public void transferIn(String name, double money) throws SQLException {
        int update = template.update("update account set money=money+? where name=?", money, name);
        if (update <= 0) {
            throw new SQLException("银行账号入账失败");
        }
    }

    public double queryMoney(String name) {
        double money = template.queryForObject("select money from  account where name=?", new Object[]{name}, Double.class);
        return money;
    }
}
