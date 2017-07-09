package com.ssmtemplate.service.impl;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  

import com.ssmtemplate.mapper.UserMapper;
import com.ssmtemplate.model.User;
import com.ssmtemplate.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}

}
