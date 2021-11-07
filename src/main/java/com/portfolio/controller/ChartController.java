package com.portfolio.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.controller.dto.ChartAssetOutDto;
import com.portfolio.model.Stock;
import com.portfolio.service.AssetService;
import com.portfolio.service.StockService;
import com.portfolio.service.dto.AllKouzaAssetOutDto;

@Controller
public class ChartController {
	@Autowired
	StockService stockService;

	@Autowired
	AssetService assetService;

	@GetMapping("/chart")
	public String getChart(Model model) {
		//Spring Securityによるユーザ情報のセッション管理
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();

		// 口座区分をグルーピングして、資産を取得
		List<AllKouzaAssetOutDto> allKouzaAssetoutDtoList = assetService.findGrpByKouzaData(userId);

		List<ChartAssetOutDto> chartAssetOutDtoList = new ArrayList<ChartAssetOutDto>();
		for(AllKouzaAssetOutDto asset : allKouzaAssetoutDtoList) {
			Stock stock = stockService.findById(asset.getStockId());

			ChartAssetOutDto chartAssetOutDto = new ChartAssetOutDto();
			chartAssetOutDto.setStockCode(stock.getStockCode());
			chartAssetOutDto.setTotalInvestment(Double.parseDouble(asset.getStockNum()),
					Double.parseDouble(asset.getAveUnitPrice()));

			chartAssetOutDtoList.add(chartAssetOutDto);
		}

		//投資額で、OutDtoListをソート
		Collections.sort(chartAssetOutDtoList,
				new Comparator<ChartAssetOutDto>() {
					@Override
					public int compare(ChartAssetOutDto obj1, ChartAssetOutDto obj2) {
						return Double.compare(obj2.getTotalInvestment(), obj1.getTotalInvestment());
					}
				}
		);

		List<String> stockCodeList = new ArrayList<String>();
		List<Double> totalInvestmentList = new ArrayList<Double>();

		for( ChartAssetOutDto chartAssetOutDto : chartAssetOutDtoList) {
			stockCodeList.add(chartAssetOutDto.getStockCode());

			//小数点3位以下切り捨て
			BigDecimal numDecBefore = new BigDecimal(chartAssetOutDto.getTotalInvestment());
			BigDecimal numDecAfter = numDecBefore.setScale(2,BigDecimal.ROUND_DOWN);
			totalInvestmentList.add(numDecAfter.doubleValue());
		}

		model.addAttribute("data", totalInvestmentList);
		model.addAttribute("label", stockCodeList);

		return "chart";
	}

}
