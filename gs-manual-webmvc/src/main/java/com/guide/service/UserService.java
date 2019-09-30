package com.guide.service;



import com.guide.domain.Member;

import java.util.List;

/**
 * 用户服务类
 *
 * @author TomLuo
 * @date 2019/9/28
 */
public interface UserService {
    /**
     * 查询所有的用户
     *
     * @return
     */
    List<Member> findAllMembers();
}
