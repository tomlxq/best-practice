package com.example.mappers;

import com.example.domain.User;

import java.util.List;

/**
 * Created by tom on 2016/5/21.
 */

public interface UserMapper
{

    void insertUser(User user);

    User findUserById(Integer id);

    List<User> findAllUsers();

}