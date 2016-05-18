package com.example.ibatis;

import com.example.entities.Account;

/**
 * Created by tom on 2016/5/18.
 */
public interface AccountDao {
    Long insertAccount(Account account);

    void deleteAccount(Account account);
}

