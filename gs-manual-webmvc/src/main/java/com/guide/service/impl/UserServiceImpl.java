package com.guide.service.impl;


import com.guide.domain.Member;
import com.guide.service.UserService;
import org.springframework.web.annotation.Autowired;
import org.springframework.web.annotation.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/28
 */
@Service(value = "userServiceKK")
public class UserServiceImpl implements UserService {
    @Override
    public List<Member> findAllMembers() {
        return Arrays.asList(
                new Member(1L, "tom", new Random().nextInt(100)),
                new Member(2L, "jimmy", new Random().nextInt(100)),
                new Member(3L, "jack", new Random().nextInt(100)),
                new Member(4L, "roze", new Random().nextInt(100)),
                new Member(5L, "green", new Random().nextInt(100)));
    }
}
