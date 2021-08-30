package com.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Asset;

@Mapper
public interface AssetMapper {
	@Select("SELECT * FROM asset")
	public List<Asset> findAll();


}
