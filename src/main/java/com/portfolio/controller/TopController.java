package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.service.StockService;

@Controller
public class TopController {

	@Autowired
	StockService stockService;

	@GetMapping("/top")
	public String getTop() {
		return "top";
	}



}
