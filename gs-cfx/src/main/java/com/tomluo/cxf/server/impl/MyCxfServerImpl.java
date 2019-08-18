package com.tomluo.cxf.server.impl;

import com.tomluo.cxf.server.IMyCxfServer;

import javax.jws.WebService;

/**
 * Created by tom on 2017/2/15.
 */
@WebService
public class MyCxfServerImpl implements IMyCxfServer {

    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }

}
