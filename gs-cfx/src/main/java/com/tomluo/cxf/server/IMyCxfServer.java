/**
 * Created by tom on 2017/2/15.
 */
package com.tomluo.cxf.server;

import javax.jws.WebService;

@WebService
public interface IMyCxfServer {
    String sayHello(String name);
}
