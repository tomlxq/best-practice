package com.tom;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
public class Storage {

    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "tom", 18),
            new User(2, "jack", 18),
            new User(3, "lisa", 25),
            new User(4, "green", 26),
            new User(6, "polly", 17),
            new User(7, "rose", 18)
    ));

    public static List<User> getUsers() {
        return users;
    }

    public static User getUser(int id) {
        User tempUser = users.stream().filter(vo -> vo.getId() == id).findFirst().get();
        return tempUser;
    }

    public static void add(User user) {
        users.add(user);
    }

    public static void update(User user) {
        User tempUser = users.stream().filter(vo -> vo.getId() == user.getId()).findFirst().get();
        if (tempUser != null) {
            BeanUtils.copyProperties(tempUser, user);
        }
    }

    public static void delete(int id) {
        Predicate<User> predicate = (s) -> s.getId() == id;
        users.removeIf(predicate);
    }

}
