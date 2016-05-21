package com.example;

import com.example.domain.User;
import com.example.mappers.UserAnnotationMapper;
import com.example.mappers.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GsMybatisApplication.class)
@WebAppConfiguration
public class GsMybatisApplicationTests {
	Logger logger = LoggerFactory.getLogger(GsMybatisApplication.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserAnnotationMapper userMapper2;

	@Test
	public void contextLoads() {
		findAllUsers();
		findUserById();
		createUser();
	}

	@Test
	public void findAllUsers()  {
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());

	}

	@Test
	public void findUserById()  {
		User user = userMapper.findUserById(1);
		assertNotNull(user);
	}

	@Test
	public void createUser() {
		User user = new User(0, "tomluo", "tomluo@gmail.com");
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getId());
		assertEquals("tomluo", newUser.getName());
		assertEquals("tomluo@gmail.com", newUser.getEmail());
	}

	@Test
	public void findAllUsers2() {
		List<User> users = userMapper2.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());

	}

	@Test
	public void findUserById2() {
		User user = userMapper2.findUserById(1);
		assertNotNull(user);
	}

	@Test
	public void createUser2() {
		User user = new User(0, "tomluo", "tomluo@gmail.com");
		userMapper2.insertUser(user);
		logger.debug("###{}", user);
		User newUser = userMapper2.findUserById(user.getId());
		assertEquals("tomluo", newUser.getName());
		assertEquals("tomluo@gmail.com", newUser.getEmail());
	}
}
