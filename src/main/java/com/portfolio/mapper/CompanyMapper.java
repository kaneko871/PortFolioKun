package com.portfolio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Company;

@Mapper
public interface CompanyMapper {
	@Insert("insert into company(user_id,company_name) "
			+ "values (#{userId},#{companyName})")
	public int insertCompany(Company company);
	
	@Select("select * from company where user_id = #{userId}")
	public List<Company> getCompanyListbyUserId(String userId);
}
