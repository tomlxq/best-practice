package com.example.mappers;

import com.example.domain.User;

import java.util.List;

/**
 * Created by tom on 2016/5/21.
 */

public interface UserMapper
{

    void insertUser(User user);

    User findUserById(String id);

    List<User> findAllUsers();

    void insertUsersBatch(List<User> list);
    void updateUsersBatch(List<User> list);
    void deleteUsersBatch(List<User> list);


}