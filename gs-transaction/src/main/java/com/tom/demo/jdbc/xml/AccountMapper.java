package com.tom.demo.jdbc.xml;

import com.tom.demo.dto.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account student = new Account();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setMoney(rs.getDouble("money"));
        return student;
    }
}

