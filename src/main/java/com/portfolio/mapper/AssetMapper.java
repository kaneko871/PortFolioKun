package com.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Asset;

@Mapper
public interface AssetMapper {
	@Select("SELECT * FROM asset where user_id = #{userId}")
	public List<Asset> findAllByUserId(String userId);

	@Insert("insert into asset(user_id, company_id, kouza_kubun, "
			+ "stock_id,stock_num, ave_unit_price) "
			+ "values(#{userId},#{companyId},#{kouzaKubun},"
			+ "#{stockId},#{stockNum},#{aveUnitPrice})")
	public void insertAsset(Asset asset);
	
	@Select("select * from asset "
			+ "where user_id = #{userId} and stock_id = #{stockId}")
	public List<Asset> getAssetListByStockId(String userId, String stockId);
}
