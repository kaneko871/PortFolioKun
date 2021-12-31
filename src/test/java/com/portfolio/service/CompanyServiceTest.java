package com.portfolio.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.portfolio.mapper.CompanyMapper;
import com.portfolio.model.Company;

@SpringBootTest
public class CompanyServiceTest {
	@Autowired
	private CompanyService companyService;
	
	@MockBean
	private CompanyMapper companyMapper;
	
	@BeforeEach
	void setUp() {
		Company expectedCompany1 = new Company();
		expectedCompany1.setUserId("hoge");
		expectedCompany1.setCompanyId("1");
		expectedCompany1.setCompanyName("SBI");

		Company expectedCompany2 = new Company();
		expectedCompany2.setUserId("hoge");
		expectedCompany2.setCompanyId("2");
		expectedCompany2.setCompanyName("楽天");

		List<Company> companyList = new ArrayList<Company>();
		companyList.add(expectedCompany1);
		companyList.add(expectedCompany2);
		
		Mockito.when(companyMapper.getCompanyListbyUserId(
				"hoge")).thenReturn(companyList);
	}

	@Test
	public void getCompanyListbyUserIdで会社リスト取得_正常() throws Exception{
		String userId="hoge";
		List<Company> companyList = companyService.getCompanyListbyUserId(userId);
		
		for(int i=0; i<companyList.size();i++) {
			assertThat(companyList.get(i).getUserId()).isEqualTo("hoge");
			if(companyList.get(i).getCompanyId()=="1") {
				assertThat(companyList.get(i).getCompanyName()).isEqualTo("SBI");
			}else {
				assertThat(companyList.get(i).getCompanyName()).isEqualTo("楽天");
				assertThat(companyList.get(i).getCompanyId()).isEqualTo("2");
			}
		}
	}
	
}
