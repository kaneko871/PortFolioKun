package com.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.CompanyMapper;
import com.portfolio.model.Company;
import com.portfolio.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyMapper companyMapper;
	
	//証券会社登録
	@Override
	public void insertCompany(Company company) {
		int maxCompanyId = companyMapper.selectMaxCompanyId();
		
		company.setCompanyId(String.valueOf(maxCompanyId+1));
		companyMapper.insertCompany(company);
	}
}
