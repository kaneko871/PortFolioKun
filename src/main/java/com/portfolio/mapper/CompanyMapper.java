package com.portfolio.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.Company;

@Mapper
public interface CompanyMapper {
	@Select("select max(company_id) from company")
	public int selectMaxCompanyId();
	
	@Insert("insert into company(company_id,company_name) values (#{companyId}, #{companyName})")
	public int insertCompany(Company company);
	
}
