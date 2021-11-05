package com.portfolio.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.portfolio.form.SignupForm;
import com.portfolio.model.PfkUser;
import com.portfolio.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class SignupController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;


	/* ユーザ登録画面表示 */
	@GetMapping("/signup")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {
		return "signup";
	}

	/* ログイン画面表示 */
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute SignupForm form) {

		// formのフィールドをuserへコピー
		PfkUser user = modelMapper.map(form, PfkUser.class);

		//ユーザ登録
		userService.signupUser(user);

		log.info(form.toString());

		return "redirect:/login";
	}
}
