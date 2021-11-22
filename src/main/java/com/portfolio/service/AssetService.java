package com.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.model.Asset;
import com.portfolio.service.dto.AllKouzaAssetOutDto;

@Service
public interface AssetService {
	public List<Asset> findAllByUserId(String userId);
	public List<AllKouzaAssetOutDto> findGrpByKouzaData(String userId);


}
