package com.portfolio.service.impl;

import java.util.List;

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
	public void insertCompany(Company company, String userId) {
		company.setUserId(userId);
		companyMapper.insertCompany(company);
	}

	@Override
	public List<Company> getCompanyListbyUserId(String userId) {
		return companyMapper.getCompanyListbyUserId(userId);
	}
}
