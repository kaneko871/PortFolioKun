package com.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.UserMapper;
import com.portfolio.model.User;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public User findLoginUser(String userId) {
		return userMapper.findById(userId);
	}



}
