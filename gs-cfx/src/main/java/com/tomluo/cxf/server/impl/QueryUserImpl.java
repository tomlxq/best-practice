package com.tomluo.cxf.server.impl;

import com.tomluo.cxf.server.IQueryUser;

import javax.jws.WebService;

/**
 * Created by tom on 2017/2/16.
 */
@WebService(endpointInterface="com.tomluo.cxf.server.IQueryUser")
public class QueryUserImpl implements IQueryUser
{
    public String query(UserInfo user)
    {
        if (user == null)
            throw new IllegalArgumentException("参数user不能为null");
        return "your name is " + user.getUserName();
    }
}
