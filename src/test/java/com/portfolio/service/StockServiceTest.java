package com.portfolio.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.portfolio.mapper.StockMapper;
import com.portfolio.model.Stock;

@SpringBootTest
class StockServiceTest {
	@Autowired
	private StockService stockService;

	@MockBean
	private StockMapper stockMapper;


	@BeforeEach
	void setUp() {
		Stock expectedStock = new Stock();
		expectedStock.setStockId(9999);
		expectedStock.setStockCode("8888");
		expectedStock.setStockName("XYZ");

		Mockito.when(stockMapper.findById(expectedStock.getStockId()))
			.thenReturn(expectedStock);
	}

	@Test
	public void findByIdでstockを取得_正常() throws Exception {
		int stockId = 9999;
		Stock actualStock=stockService.findById(stockId);

		//org.assertj.core.api.Assertions.assertThat
		assertThat(actualStock.getStockId()).isEqualTo("9999");
		assertThat(actualStock.getStockCode()).isEqualTo("8888");
		assertThat(actualStock.getStockName()).isEqualTo("XYZ");
	}



}
