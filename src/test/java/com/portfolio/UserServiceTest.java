package com.portfolio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portfolio.model.PfkUser;
import com.portfolio.service.UserService;

class UserServiceTest {

	// Spring Securityの話もあるため、難易度が高いから後回し
	@Test
	void getLoginUserでユーザを取得() throws Exception{
		PfkUser pfkUser = new PfkUser();
		pfkUser.setUserId("sampleId");
		pfkUser.setPassword("pass");

		UserService userService = new UserService();
		userService.signupUser(pfkUser);

		String userId= "sampleId";
		PfkUser actual=userService.getLoginUser(userId);

		PfkUser expected = new PfkUser();
		expected.setUserId("sampleId");
		expected.setPassword("pass");
		assertEquals(actual, expected);
	}

}
