package com.example.web;

import com.example.entity.Article;
import com.example.entity.Person;
import com.example.entity.ResultBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * HelloController
 *
 * @author TomLuo
 * @date 2023年04月19日 22:32
 */
@RestController
public class HelloController {
    @GetMapping("/hello2")
    public ResultBody test2() {

        final Article article = new Article();
        article.setBirthday(new Date());
        article.setCreateTime(new Date());
        article.setCreateDate(new Date());
        return ResultBody.success(article);
    }
        @GetMapping("/hello")
    public ResultBody test() {


        Person obj1 = new Person("张三", 48);

        List<Person> list = new ArrayList<>();

        list.add(obj1);

        Person obj2 = new Person("李四", 23);

        list.add(obj2);

        Person obj3 = new Person("王麻子", 17);

        list.add(obj3);

        List<Person> young = list.stream().filter(e -> e.getAge() <= 45).collect(Collectors.toList());
        List<Person> children = list.stream().filter(e -> e.getAge() < 18).collect(Collectors.toList());

        HashMap map = new HashMap();
        map.put("young", young);

        map.put("children", children);

        return ResultBody.success(map);


    }
}