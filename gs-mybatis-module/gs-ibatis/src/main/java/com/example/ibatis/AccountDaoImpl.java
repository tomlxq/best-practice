package com.example.ibatis;

import com.example.entities.Account;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * Created by tom on 2016/5/18.
 */
@Repository
public class AccountDaoImpl
 extends SqlMapClientDaoSupport implements AccountDao {
    @Autowired
    public AccountDaoImpl(SqlMapClient sqlMapClient) {
        super.setSqlMapClient(sqlMapClient);
    }

    @Override
    public Long insertAccount(Account account) {
        return (Long)getSqlMapClientTemplate().insert("insertAccount",account);
    }

    @Override
    public void deleteAccount(Account account) {
        getSqlMapClientTemplate().delete("deleteAccount",account);
    }
}
