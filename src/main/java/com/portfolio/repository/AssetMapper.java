package com.portfolio.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Asset;

@Mapper
public interface AssetMapper {
	@Select("SELECT * FROM asset where user_id = #{userId}")
	public List<Asset> findAllByUserId(String userId);

}
