package com.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.controller.dto.OwnedAssetOutDto;
import com.portfolio.model.Asset;
import com.portfolio.model.Stock;
import com.portfolio.service.AssetService;
import com.portfolio.service.StockService;

@Controller
public class TopController {

	@Autowired
	StockService stockService;

	@Autowired
	AssetService assetService;

	@GetMapping("/top")
	public String getTop(Model model) {
		List<Asset> assetList = assetService.findAll();

		List<OwnedAssetOutDto> ownedAssetOutDtoList = new ArrayList<OwnedAssetOutDto>();

		for(Asset asset : assetList) {
			Stock stock = stockService.findById(asset.getStockId());

			OwnedAssetOutDto ownedAssetOutDto = new OwnedAssetOutDto();
			ownedAssetOutDto.setStockCode(stock.getStockCode());
			ownedAssetOutDto.setStockName(stock.getStockName());
			ownedAssetOutDto.setStockNum(asset.getStockNum());
			ownedAssetOutDto.setAveUnitPrice(asset.getAveUnitPrice());

			ownedAssetOutDtoList.add(ownedAssetOutDto);
		}

		model.addAttribute("ownedAssetList", ownedAssetOutDtoList);

		return "top";
	}




}
