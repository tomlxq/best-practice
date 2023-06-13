package com.tom.example2.web;

import com.tom.example2.model.AjaxResult;
import com.tom.example2.model.User;
import com.tom.example2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author TomLuo
 * @date 2023年03月01日 20:57
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public AjaxResult list() {
        return AjaxResult.success(userService.list());
    }

    @PostMapping("/add")
    public AjaxResult add(@RequestBody User user) {
        return AjaxResult.success(userService.save(user));
    }
}