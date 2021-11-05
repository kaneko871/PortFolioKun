package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {

	/* ユーザ登録画面表示 */
	@GetMapping("/signup")
	public String getSignup(Model model) {
		return "signup";

	}

}
