package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.portfolio.form.RegisterCompanyForm;

@Controller
public class RegisterController {

	@GetMapping("/register/company")
	public String getRegisterCompany(Model model, @ModelAttribute RegisterCompanyForm form) {
		return "register/company";
	}
	
	@PostMapping("/register/company")
	public String postRegisterCompany(@ModelAttribute RegisterCompanyForm form) {
		return "top";
	}

}
