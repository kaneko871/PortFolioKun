package com.portfolio.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.portfolio.mapper.StockMapper;
import com.portfolio.model.Stock;
import com.portfolio.service.impl.StockServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class StockServiceTest {

	@TestConfiguration
	static class StockServiceImplTestContextConfiguration{
		@Bean
		public StockService stockService() {
			return new StockServiceImpl();
		}
	}

	@Autowired
	private StockService stockService;

	@MockBean
	private StockMapper stockMapper;


	@BeforeEach
	void setUp() {
		Stock expectedStock = new Stock();
		expectedStock.setStockId("9999");
		expectedStock.setStockCode("8888");
		expectedStock.setStockName("XYZ");

		Mockito.when(stockMapper.findById(expectedStock.getStockId()))
			.thenReturn(expectedStock);
	}

	@Test
	public void findByIdでstockを取得_正常() throws Exception {
		String stockId = "9999";
		Stock actualStock=stockService.findById(stockId);

		//org.assertj.core.api.Assertions.assertThat
		assertThat(actualStock.getStockId()).isEqualTo("9999");
		assertThat(actualStock.getStockCode()).isEqualTo("8888");
		assertThat(actualStock.getStockName()).isEqualTo("XYZ");
	}



}
