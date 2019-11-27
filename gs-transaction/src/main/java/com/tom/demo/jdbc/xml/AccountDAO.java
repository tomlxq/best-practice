package com.tom.demo.jdbc.xml;

import com.tom.demo.dto.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
@Repository
public class AccountDAO {
    private JdbcTemplate template;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public int add(String name) {
        String SQL = "insert into account (name, money) values (?, ?)";

        int update = template.update(SQL, name, new Random().nextDouble());
        System.out.println("Created Record Name = " + name);
        return update;
    }

    public Account getAccount(Integer id) {
        String SQL = "select * from account where id = ?";
        Account account = template.queryForObject(SQL,
                new Object[]{id}, new AccountMapper());
        return account;
    }

    public List<Account> listAccounts() {
        String SQL = "select * from account";
        List<Account> students = template.query(SQL,
                new AccountMapper());
        return students;
    }

    public int delete(Integer id) {
        String SQL = "delete from account where id = ?";
        int update = template.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return update;
    }

    public int update(Integer id, String name, double money) {
        String SQL = "update account set name=?,money = ? where id = ?";
        int update = template.update(SQL, name, money, id);
        System.out.println("Updated Record with ID = " + id);
        return update;
    }
}

