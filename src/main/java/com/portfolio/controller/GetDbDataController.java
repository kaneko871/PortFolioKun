package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolio.model.Asset;
import com.portfolio.model.Stock;
import com.portfolio.service.AssetService;
import com.portfolio.service.StockService;

@Controller
public class GetDbDataController {

	@Autowired
	StockService stockService;

	@Autowired
	AssetService assetService;

	@GetMapping("/get-stock")
	@ResponseBody
	public List<Stock> getStock() {

		List<Stock> stockList = stockService.findAll();
		return stockList;

	}

	@GetMapping("/get-asset")
	@ResponseBody
	public List<Asset> getAsset() {

		List<Asset> stockList = assetService.findAll();
		return stockList;

	}


}
