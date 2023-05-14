package com.tom.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tom.entities.User;
import com.tom.enums.SexEnum;
import com.tom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 用户controller
 *
 * @author TomLuo
 * @date 2023年05月14日 10:09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * description: 新增
     *
     * @return: boolean
     * @author: weirx
     * @time: 2022/1/17 19:11
     */
    @RequestMapping("/save")
    public boolean save() {
        User userDO = new User();
        userDO.setNickname("大漂亮");
        userDO.setSex(SexEnum.MAN);

        return userService.save(userDO);
    }

    /**
     * description: 修改
     *
     * @param nickname
     * @param id
     * @return: boolean
     * @author: weirx
     * @time: 2022/1/17 19:11
     */
    @RequestMapping("/update")
    public boolean update(@RequestParam String nickname, @RequestParam Long id) {
        User userDO = new User();
        userDO.setNickname(nickname);
        userDO.setId(id);
        return userService.updateById(userDO);
    }

    /**
     * description: 删除
     *
     * @param id
     * @return: boolean
     * @author: weirx
     * @time: 2022/1/17 19:11
     */
    @RequestMapping("/delete")
    public boolean delete(@RequestParam Long id) {
        User userDO = new User();
        userDO.setId(id);
        return userService.removeById(userDO);
    }

    /**
     * description: 列表
     *
     * @return: java.util.List<com.wjbgn.user.entity.User>
     * @author: weirx
     * @time: 2022/1/17 19:11
     */
    @RequestMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    /**
     * description: 分页列表
     *
     * @param current
     * @param size
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page
     * @author: weirx
     * @time: 2022/1/17 19:11
     */
    @RequestMapping("/page")
    public Page page(@RequestParam int current, @RequestParam int size) {
        return userService.page(new Page<>(current, size), new QueryWrapper(new User()));
    }

}