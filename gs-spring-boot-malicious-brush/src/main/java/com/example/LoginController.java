package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LoginController
 *
 * @author TomLuo
 * @date 2023年06月04日 22:02
 */
public class LoginController {
    @RequestMapping("/api/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        if(!checkUser(username, password)){
            return "用户名或密码错误";
        }
        String token = getToken();
        saveToken(token);
        return token;
    }

    private boolean checkUser(String username, String password){
        //校验用户是否合法
        return true;
    }

    private String getToken(){
        //生成token
        return null;
    }

    private void saveToken(String token){
        //保存token
    }
}