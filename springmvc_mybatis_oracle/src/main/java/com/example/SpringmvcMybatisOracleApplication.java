package com.example;

import com.example.domain.User;
import com.example.mappers.UserMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@SpringBootApplication
@MapperScan("com.example.mappers")
public class SpringmvcMybatisOracleApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringmvcMybatisOracleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcMybatisOracleApplication.class, args);
	}

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = {"", "/"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		//添加模型数据 可以是任意的POJO对象
		//mv.addObject("message", "Hello World!");
		List<User> users = userMapper.findAllUsers();
		mv.addObject("users", users);
		//设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("index");
		//logger.debug("#####");
		//List<User> users = userMapper.findAllUsers();
		//logger.debug("{}",users);
		//logger.debug("#####");
		return mv;
	}

	@RequestMapping(value = {"/insertUsersBatch"})
	public String insertUsersBatch() {
		List<User> users = new ArrayList<User>();
		users.add(new User(UUID.randomUUID().toString(),"lindao","lindao@google.com",17f,DateUtils.addWeeks(new Date(), 25)));

		users.add(new User(UUID.randomUUID().toString(),"polly","polly@google.com",25f,DateUtils.addWeeks(new Date(), 48)));

		users.add(new User(UUID.randomUUID().toString(),"Hanmeimei","Hanmeimei@google.com",78f,DateUtils.addWeeks(new Date(), 78)));
		users.add(new User("4","liyun","liyun@google.com",55f,DateUtils.addWeeks(new Date(), 55)));
		users.add(new User("5","desk","desk@google.com",66f,DateUtils.addWeeks(new Date(), 77)));

		userMapper.insertUsersBatch(users);
		return "redirect:/";
	}
	@RequestMapping(value = {"/updateUsersBatch"})
	public String updateUsersBatch() {
		List<User> users = new ArrayList<User>();
		User user=new User();
		user.setId("1");
		user.setAge(19f);
		users.add(user);
		user=new User();
		user.setId("2");
		user.setAge(20f);
		users.add(user);
		userMapper.updateUsersBatch(users);
		return "redirect:/";
	}
	@RequestMapping(value = {"/deleteUsersBatch"})
	public String deleteUsersBatch() {
		List<User> users = new ArrayList<User>();
		User user=new User();
		user.setId("4");
		users.add(user);
		user=new User();
		user.setId("5");
		users.add(user);
		userMapper.deleteUsersBatch(users);
		return "redirect:/";
	}
}
