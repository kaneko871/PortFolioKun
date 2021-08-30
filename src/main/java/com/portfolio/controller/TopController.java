package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolio.model.Stock;
import com.portfolio.service.StockService;

@Controller
public class TopController {

	@Autowired
	StockService stockService;

	//TODO: 一時的にDBのデータを見るように変更してるので、画面を返却するようにする
	/*	@GetMapping("/top")
		public String getTop() {
			return "top";
		}
	*/

	@GetMapping("/top")
	@ResponseBody
	public List<Stock> getTop() {
		//return "top";

		List<Stock> stockList = stockService.findAll();
		return stockList;

	}


}
