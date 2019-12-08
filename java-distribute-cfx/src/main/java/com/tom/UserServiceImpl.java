package com.tom;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.tom.Response.SUCCESS_CODE;
import static com.tom.Response.SUCCESS_DESC;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUsers() {
        return Storage.getUsers();
    }

    @Override
    public User getUser(int id) {
        return Storage.getUser(id);
    }

    @Override
    public Response delete(int id) {
        Storage.delete(id);

        return new Response(SUCCESS_CODE, SUCCESS_DESC);
    }

    @Override
    public Response update(User user) {
        Storage.update(user);
        return new Response(SUCCESS_CODE, SUCCESS_DESC);
    }

    @Override
    public Response add(User user) {
        Storage.add(user);
        return new Response(SUCCESS_CODE, SUCCESS_DESC);
    }
}
