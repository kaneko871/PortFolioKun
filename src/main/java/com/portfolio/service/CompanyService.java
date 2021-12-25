package com.portfolio.service;

import org.springframework.stereotype.Service;

import com.portfolio.model.Company;

public interface CompanyService {

	public void insertCompany(Company company, String userId);
}
