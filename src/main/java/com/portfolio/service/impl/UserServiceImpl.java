package com.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.UserMapper;
import com.portfolio.model.PfkUser;
import com.portfolio.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;

	@Autowired
	private PasswordEncoder encoder;

	//ユーザ登録
	@Override
	public void signupUser(PfkUser user) {
		//パスワードハッシュ化
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		userMapper.insertUser(user);
	}


	@Override
	public PfkUser getLoginUser(String userId) {
		return userMapper.findById(userId);
	}



}
