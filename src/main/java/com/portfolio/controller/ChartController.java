package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

	@GetMapping("/chart")
	public String getChart(Model model) {

		return "chart";
	}

}
