package com.portfolio.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.portfolio.form.RegisterAssetForm;
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();


		Company company = modelMapper.map(form, Company.class);
		
		companyService.insertCompany(company,userId);
		
		return "top";
	}

	@GetMapping("/register/stock")
	public String getRegisterStock(Model model, @ModelAttribute RegisterStockForm form) {
		return "register/stock";
	}
	
	@PostMapping("/register/stock")
	public String postRegisterStock(@ModelAttribute RegisterStockForm form) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		
		Stock stock = modelMapper.map(form, Stock.class);
		stockService.insertStock(stock,userId);
		return "top";
	}

	@GetMapping("/register/asset")
	public String getRegisterAsset(Model model, @ModelAttribute RegisterAssetForm form) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		
		//証券会社プルダウン
		List<Company> companyList = companyService.getCompanyListbyUserId(userId);
		model.addAttribute(companyList);

		//株式コードプルダウン
		List<Stock> stockList = stockService.getStockListByuserId(userId);
		model.addAttribute(stockList);
		
		return "register/asset";
	}
	
	@PostMapping("/register/asset")
	public String postRegisterAsset(@ModelAttribute RegisterAssetForm form) {
		
		return "top";
	}


	
}
