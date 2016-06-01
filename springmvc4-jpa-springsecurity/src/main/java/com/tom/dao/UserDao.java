package com.tom.dao;

import com.tom.entities.User;

import java.util.List;

/**
 * Created by tom on 2016/6/1.
 */
public interface UserDao {

    public List<User> findAll();

    public User create(User user);

    public User findUserById(int id);

    public User login(String email, String password);

}