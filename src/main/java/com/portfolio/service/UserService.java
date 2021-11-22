package com.portfolio.service;

import org.springframework.stereotype.Service;

import com.portfolio.model.PfkUser;


@Service
public interface UserService {

	//ユーザ登録
	public void signupUser(PfkUser user);

	public PfkUser getLoginUser(String userId);

}
