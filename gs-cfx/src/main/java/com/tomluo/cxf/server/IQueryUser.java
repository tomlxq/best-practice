package com.tomluo.cxf.server;

import com.tomluo.cxf.server.impl.UserInfo;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by tom on 2017/2/16.
 */
@WebService(targetNamespace="http://localhost:8080/queryUser")
public interface IQueryUser {
    String query(@WebParam(name = "user") UserInfo user);
}