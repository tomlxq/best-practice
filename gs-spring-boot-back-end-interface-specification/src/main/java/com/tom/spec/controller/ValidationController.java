package com.tom.spec.controller;

import com.tom.domain.ResultVO;
import com.tom.domain.User;
import com.tom.spec.service.Update;
import com.tom.spec.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月11日 5:56
 */
@RestController
@RequestMapping("user")
public class ValidationController {

    @Autowired
    private ValidationService validationService;
    @PostMapping("/addUser1")
    public String addUser(@RequestBody @Validated User user, BindingResult bindingResult) {
        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(!allErrors.isEmpty()){
            return allErrors.stream()
                    .map(o->o.getDefaultMessage())
                    .collect(Collectors.toList()).toString();
        }
        // 返回默认的错误信息
        // return allErrors.get(0).getDefaultMessage();
        return validationService.addUser(user);
    }
    @PostMapping("/addUser")
    public String addUser(@RequestBody @Validated User user) {
        return validationService.addUser(user);
    }

    @PostMapping("update")
    public String update(@Validated({Update.class}) User user) {
        return "success";
    }
    /*@GetMapping("/getUser")
    public ResultVO<User> getUser() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");

        return new ResultVO<>(user);
    }*/
    @GetMapping("/getUser")
//@NotResponseBody  //是否绕过数据统一响应开关
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        // 注意哦，这里是直接返回的User类型，并没有用ResultVO进行包装
        return user;
    }
}