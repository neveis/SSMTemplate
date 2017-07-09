package com.ssmtemplate.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;

import com.ssmtemplate.model.User;
import com.ssmtemplate.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class SpringMyBatisTest {

	@Resource
	private UserService userService;
	
	@Test
	public void testGetUser(){
		User user = userService.getUserById(1);
		System.out.println(JSON.toJSONString(user));
	}
}
