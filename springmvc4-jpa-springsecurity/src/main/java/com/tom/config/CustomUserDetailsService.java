package com.tom.config;

import com.tom.entities.User;
import com.tom.service.UserService;
import com.tom.web.config.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by tom on 2016/6/1.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userService.findUserByEmail(userName);
        if(user == null){
            throw new UsernameNotFoundException("UserName "+userName+" not found");
        }
        return new SecurityUser(user);
    }

}
