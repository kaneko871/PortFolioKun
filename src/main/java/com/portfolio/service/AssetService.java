package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.AssetMapper;
import com.portfolio.model.Asset;

@Service
public class AssetService {
	@Autowired
	AssetMapper assetMapper;


	public List<Asset> findAll(){
		List<Asset> assetList = assetMapper.findAll();
		return assetList;
	}

}
