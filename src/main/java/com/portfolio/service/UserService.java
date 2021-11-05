package com.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.UserMapper;
import com.portfolio.model.User;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	@Autowired
	private PasswordEncoder encoder;

	//ユーザ登録
	public void signupUser(User user) {
		//パスワードハッシュ化
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		userMapper.insertUser(user);
	}


	public User findLoginUser(String userId) {
		return userMapper.findById(userId);
	}



}
