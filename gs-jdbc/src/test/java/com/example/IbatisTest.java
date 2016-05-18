package com.example;

import com.example.ibatis.AccountDao;
import com.example.entities.Account;
import com.example.ibatis.AccountDaoImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resources;
import java.io.Reader;
import java.util.Date;

/**
 * Created by tom on 2016/5/18.
 */
public class IbatisTest extends IbatisBaseTest {
    @Autowired
    AccountDao accountDao;
    @Test
    public void test(){
        //add
        Account account=new Account("tom","123","qq2@gmail.com",0,new Date());
        Long id=accountDao.insertAccount(account);
        //delete
        accountDao.deleteAccount(account);
    }
}
