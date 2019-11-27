package com.tom.demo.jdbc.annotation.service;

import com.tom.demo.jdbc.annotation.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
@Service
@Slf4j
public class InAccountService {
    @Autowired
    private AccountDao accountDao;

    @Transactional(rollbackFor = SQLException.class, propagation = Propagation.REQUIRED)
    public void transferIn(String in, double money) throws SQLException {
        accountDao.transferIn(in, money);
    }
}
