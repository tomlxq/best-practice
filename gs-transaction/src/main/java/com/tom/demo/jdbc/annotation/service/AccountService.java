package com.tom.demo.jdbc.annotation.service;

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
public class AccountService {


    @Autowired
    private OutAccountService outAccountService;

    @Autowired
    private InAccountService inAccountService;

    @Transactional(rollbackFor = SQLException.class, propagation = Propagation.REQUIRED)
    public void transfer(String out, String in, double money) throws SQLException {
        inAccountService.transferIn(in, money);
        outAccountService.transferOut(out, money);

    }


}
