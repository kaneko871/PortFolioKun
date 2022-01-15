package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.portfolio.model.Asset;
import com.portfolio.service.AssetService;
import com.portfolio.service.StockService;

@Controller
public class DetailListController {

	@Autowired
	StockService stockService;
	
	@Autowired
	AssetService assetService;
	
	@GetMapping("/list/assets/{stockCode}")
	public String getAssetDetailList(Model model,
			@PathVariable("stockCode") String stockCode) {

		System.out.println("stockCode: "+stockCode);
		model.addAttribute("stockCode", stockCode);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		
	 	String stockId = stockService.getStockIdByCode(stockCode, userId);

	 	System.out.println("stockId: " + stockId);

	 	List<Asset> assetList = assetService.getAssetListByStockId(stockId, userId);
	 	
	 	System.out.println("assetList: " + assetList);
	 	model.addAttribute("assetList",assetList);

		return "list/assets";
	}
}
