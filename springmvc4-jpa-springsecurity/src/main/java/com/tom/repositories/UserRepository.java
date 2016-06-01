package com.tom.repositories;

import com.tom.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * Created by tom on 2016/6/1.
 */
public interface UserRepository extends JpaRepository<User, Serializable> {

    @Query("select u from User u where u.email=?1 and u.password=?2")
    User login(String email, String password);

    User findByEmailAndPassword(String email, String password);

    User findUserByEmail(String email);

}