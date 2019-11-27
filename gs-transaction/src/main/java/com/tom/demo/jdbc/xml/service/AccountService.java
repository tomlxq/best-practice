package com.tom.demo.jdbc.xml.service;

import com.tom.demo.dto.Account;
import com.tom.demo.jdbc.xml.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public void add(String name) throws SQLException {
        int count = accountDAO.add(name);
        throw new SQLException("测试回滚");
    }

    public List<Account> listAccounts() {
        return accountDAO.listAccounts();
    }

    public Account getAccount(int id) {
        return accountDAO.getAccount(id);
    }

    public int delete(Integer id) {
        return accountDAO.delete(id);
    }

    public int update(Integer id, String name, double money) {
        return accountDAO.update(id, name, money);
    }

    /**
     * @param name
     * @Transactional(propagation = Propagation.MANDATORY)
     * org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'
     * <p>
     * at org.springframework.transaction.support.AbstractPlatformTransactionManager.getTransaction(AbstractPlatformTransactionManager.java:364)
     * at org.springframework.transaction.interceptor.TransactionAspectSupport.createTransactionIfNecessary(TransactionAspectSupport.java:475)
     * at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:289)
     * at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:98)
     */
    @Transactional(readOnly = true)
    public void login(String name) {
        this.update(1, name, new Random().nextDouble());
    }


}
