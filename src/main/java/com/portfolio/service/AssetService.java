package com.portfolio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.AssetMapper;
import com.portfolio.model.Asset;
import com.portfolio.service.dto.AllKouzaAssetOutDto;

@Service
public class AssetService {
	@Autowired
	AssetMapper assetMapper;


	public List<Asset> findAll(){
		List<Asset> assetList = assetMapper.findAll();
		return assetList;
	}

	public List<AllKouzaAssetOutDto> findGrpByKouzaData(){
		//List<AllKouzaAssetOutDto> allKouzaDataList = assetMapper.findAllKouzaData();
		List<Asset> assetList = assetMapper.findAll();

		// stock_idでグルーピング
		Map<String, List<Asset>> grpByStockIdMap = assetList.stream().collect(
				Collectors.groupingBy(Asset::getStockId)
		);


		List<AllKouzaAssetOutDto> allKouzaAssetOutDtoList = new ArrayList<AllKouzaAssetOutDto>();
		for(String key : grpByStockIdMap.keySet()) {

			AllKouzaAssetOutDto allKouzaAssetOutDto = new AllKouzaAssetOutDto();
			allKouzaAssetOutDto.setStockId(key);

			List<Asset> grpByStockIdList = grpByStockIdMap.get(key);

			Integer sumOfStockNum=0;
			Double sumOfAveUnitPrice=0.0;
			for(Asset asset : grpByStockIdList) {
				sumOfStockNum += Integer.parseInt(asset.getStockNum());
				sumOfAveUnitPrice += Double.parseDouble(asset.getAveUnitPrice());
			}
			Double avgOfAveUnitPrice=sumOfAveUnitPrice/grpByStockIdList.size();
			allKouzaAssetOutDto.setStockNum(sumOfStockNum.toString());
			allKouzaAssetOutDto.setAveUnitPrice(avgOfAveUnitPrice.toString());

			allKouzaAssetOutDtoList.add(allKouzaAssetOutDto);
		}


		return allKouzaAssetOutDtoList;
	}

}
