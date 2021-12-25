package com.portfolio.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.portfolio.form.RegisterCompanyForm;
import com.portfolio.form.RegisterStockForm;
import com.portfolio.model.Company;
import com.portfolio.model.Stock;
import com.portfolio.service.CompanyService;
import com.portfolio.service.StockService;

@Controller
public class RegisterController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CompanyService companyService;
	
	@Autowired 
	private StockService stockService;
	
	@GetMapping("/register/company")
	public String getRegisterCompany(Model model, @ModelAttribute RegisterCompanyForm form) {
		return "register/company";
	}
	
	@PostMapping("/register/company")
	public String postRegisterCompany(@ModelAttribute RegisterCompanyForm form) {
		
		Company company = modelMapper.map(form, Company.class);
		
		companyService.insertCompany(company);
		
		return "top";
	}

	@GetMapping("/register/stock")
	public String getRegisterStock(Model model, @ModelAttribute RegisterStockForm form) {
		return "register/stock";
	}
	
	@PostMapping("/register/stock")
	public String postRegisterStock(@ModelAttribute RegisterStockForm form) {
		Stock stock = modelMapper.map(form, Stock.class);
		stockService.insertStock(stock);
		return "top";
	}

	
	
}
