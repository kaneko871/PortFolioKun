package com.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.AssetMapper;
import com.portfolio.model.Asset;
import com.portfolio.service.AssetService;
import com.portfolio.service.dto.AllKouzaAssetOutDto;

@Service
public class AssetServiceImpl implements AssetService{
	@Autowired
	AssetMapper assetMapper;

	@Override
	public List<Asset> findAllByUserId(String userId){
		List<Asset> assetList = assetMapper.findAllByUserId(userId);
		return assetList;
	}

	@Override
	public List<AllKouzaAssetOutDto> findGrpByKouzaData(String userId){
		//List<AllKouzaAssetOutDto> allKouzaDataList = assetMapper.findAllKouzaData();
		List<Asset> assetList = assetMapper.findAllByUserId(userId);

		// stock_idでグルーピング
		Map<Integer, List<Asset>> grpByStockIdMap = assetList.stream().collect(
				Collectors.groupingBy(Asset::getStockId)
		);


		List<AllKouzaAssetOutDto> allKouzaAssetOutDtoList = new ArrayList<AllKouzaAssetOutDto>();
		for(Integer key : grpByStockIdMap.keySet()) {

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

	@Override
	public void insertAsset(Asset asset, String userId) {
		asset.setUserId(userId);
		assetMapper.insertAsset(asset);
	}

	@Override
	public List<Asset> getAssetListByStockId(String stockId, String userId) {
		return assetMapper.getAssetListByStockId(userId, stockId);
	}

	@Override
	public void deleteAsset(String userId, String companyId, String kouzaKubun, String stockId) {
		assetMapper.deleteAsset(userId, companyId, kouzaKubun, stockId);
	}



}
