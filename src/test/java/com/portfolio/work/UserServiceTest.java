package com.portfolio.work;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.portfolio.mapper.UserMapper;
import com.portfolio.model.PfkUser;
import com.portfolio.service.UserService;
import com.portfolio.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

//TODO: Spring Securityに対応したテストコードにする。	
	
	@TestConfiguration
	static class UserServiceImplTestContextConfiguration{
		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserMapper uesrMapper;


	@Test
	void getLoginUserでユーザを取得() throws Exception{
		PfkUser pfkUser = new PfkUser();
		pfkUser.setUserId("sampleId");
		pfkUser.setPassword("pass");

		userService.signupUser(pfkUser);

		String userId= "sampleId";
		PfkUser actual=userService.getLoginUser(userId);

		PfkUser expected = new PfkUser();
		expected.setUserId("sampleId");
		expected.setPassword("pass");
		assertEquals(actual, expected);
	}

}
