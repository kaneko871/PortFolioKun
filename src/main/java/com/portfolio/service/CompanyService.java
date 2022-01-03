package com.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.model.Company;

public interface CompanyService {

	public void insertCompany(Company company, String userId);
	public List<Company> getCompanyListbyUserId(String userId);
}
