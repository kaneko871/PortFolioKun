package com.portfolio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.controller.dto.AssetDetailListOutDto;
import com.portfolio.model.Asset;
import com.portfolio.service.AssetService;
import com.portfolio.service.CompanyService;
import com.portfolio.service.StockService;

@Controller
public class DetailListController {

	@Autowired
	StockService stockService;
	
	@Autowired
	AssetService assetService;
	
	@Autowired
	CompanyService companyService;

 	List<AssetDetailListOutDto> assetDetailList = new ArrayList<AssetDetailListOutDto>();
 	List<HashMap<AssetDetailListOutDto, Asset>>  assetDetailMapList = new ArrayList<HashMap<AssetDetailListOutDto, Asset>>();
 	String targetStockCode;
 	
	@GetMapping("/detail-list/asset/{stockCode}")
	public String getAssetDetailList(Model model,
			@PathVariable("stockCode") String stockCode) {

		targetStockCode=stockCode;
		String detailAssetListHeader = "資産詳細リスト " + stockCode;
		model.addAttribute("detailAssetListHeader", detailAssetListHeader);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		
	 	String stockId = stockService.getStockIdByCode(stockCode, userId);

	 	List<Asset> assetList = assetService.getAssetListByStockId(stockId, userId);
	 	
	 	assetDetailList=new ArrayList<AssetDetailListOutDto>();
	 	assetDetailMapList = new ArrayList<HashMap<AssetDetailListOutDto, Asset>>();
	 	//List<AssetDetailListOutDto> assetDetailList = new ArrayList<AssetDetailListOutDto>();
	 	for(Asset asset : assetList) {
	 		String companyId = asset.getCompanyId();
	 		String companyName = companyService.getCompanyNameById(userId, companyId);
	 		
	 		AssetDetailListOutDto assetDetailListOutDto = new AssetDetailListOutDto();
	 		assetDetailListOutDto.setCompanyName(companyName);
	 		
	 		if(asset.getKouzaKubun().equals("1")) {
	 			assetDetailListOutDto.setKouzaKubun("普通口座");
	 		}
	 		else if(asset.getKouzaKubun().equals("2")) {
	 			assetDetailListOutDto.setKouzaKubun("特定口座");
	 		}
	 		else if(asset.getKouzaKubun().equals("3")) {
	 			assetDetailListOutDto.setKouzaKubun("NISA口座");
	 		}

	 		assetDetailListOutDto.setStockNum(asset.getStockNum());
	 		assetDetailListOutDto.setAveUnitPrice(asset.getAveUnitPrice());
	 		Double totalInvestment = Double.parseDouble(asset.getStockNum())
	 				* Double.parseDouble(asset.getAveUnitPrice());
	 		assetDetailListOutDto.setTotalInvestment(totalInvestment);
	 		assetDetailList.add(assetDetailListOutDto);
	 		
	 		HashMap<AssetDetailListOutDto, Asset>  assetDetailMap = new HashMap<AssetDetailListOutDto, Asset>();
	 		assetDetailMap.put(assetDetailListOutDto,asset);
	 		assetDetailMapList.add(assetDetailMap);
	 	}
	 	
	 	model.addAttribute("assetList",assetDetailList);

		return "detail-list/asset";
	}

	
	@PostMapping("/detail-list/asset/delete")
	public String deleteAsset(Model model, @RequestParam("stat-index") String statIndex) {
		AssetDetailListOutDto assetDetailListOutDto = assetDetailList.get(Integer.parseInt(statIndex));

		Asset deleteAsset=assetDetailMapList.get(Integer.parseInt(statIndex)).get(assetDetailListOutDto);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		
		assetService.deleteAsset(userId, deleteAsset.getCompanyId(), 
				deleteAsset.getKouzaKubun(), String.valueOf(deleteAsset.getStockId()));
		
		String url = "redirect:/detail-list/asset/"+targetStockCode;
		return url;
	}
	
}
