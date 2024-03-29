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
import com.portfolio.model.Asset;
import com.portfolio.model.Company;
import com.portfolio.model.Stock;
import com.portfolio.service.AssetService;
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
	
	@Autowired
	private AssetService assetService;
	
	@GetMapping("/register/company")
	public String getRegisterCompany(Model model, @ModelAttribute RegisterCompanyForm form) {
		return "register/company";
	}
	
	@PostMapping("/register/company")
	public String postRegisterCompany(Model model,@ModelAttribute RegisterCompanyForm form) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		Company company = modelMapper.map(form, Company.class);
		companyService.insertCompany(company,userId);

		model.addAttribute("registerFlag", "completed");
		return "register/company";
	}

	@GetMapping("/register/stock")
	public String getRegisterStock(Model model, @ModelAttribute RegisterStockForm form) {
		return "register/stock";
	}
	
	@PostMapping("/register/stock")
	public String postRegisterStock(Model model, @ModelAttribute RegisterStockForm form) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		
		Stock stock = modelMapper.map(form, Stock.class);
		stockService.insertStock(stock,userId);

		model.addAttribute("registerFlag", "completed");
		return "register/stock";
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
	public String postRegisterAsset(Model model,@ModelAttribute RegisterAssetForm form) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();

		//証券会社プルダウン
		List<Company> companyList = companyService.getCompanyListbyUserId(userId);
		model.addAttribute(companyList);

		//株式コードプルダウン
		List<Stock> stockList = stockService.getStockListByuserId(userId);
		model.addAttribute(stockList);
	
		Asset asset = modelMapper.map(form, Asset.class);
		assetService.insertAsset(asset,userId);
		
		model.addAttribute("registerFlag", "completed");
		return "register/asset";
	}


	
}
