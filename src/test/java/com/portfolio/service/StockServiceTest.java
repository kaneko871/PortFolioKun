package com.portfolio.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
		expectedStock.setUserId("hoge");
		expectedStock.setStockCode("8888");
		expectedStock.setStockName("XYZ");

		Mockito.when(stockMapper.findById(expectedStock.getStockId()))
			.thenReturn(expectedStock);

		Stock expectedStock2 = new Stock();
		expectedStock2.setUserId("hoge");
		expectedStock2.setStockId(2);
		expectedStock2.setStockCode("ABC");
		expectedStock2.setStockName("ABC株");

		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(expectedStock);
		stockList.add(expectedStock2);
	
		
		Mockito.when(stockMapper.getStockListByuserId(
				"hoge")).thenReturn(stockList);
	}

	@Test
	public void findByIdでstockを取得_正常() throws Exception {
		int stockId = 9999;
		Stock actualStock=stockService.findById(stockId);

		//org.assertj.core.api.Assertions.assertThat
		assertThat(actualStock.getStockId()).isEqualTo(9999);
		assertThat(actualStock.getUserId()).isEqualTo("hoge");
		assertThat(actualStock.getStockCode()).isEqualTo("8888");
		assertThat(actualStock.getStockName()).isEqualTo("XYZ");
	}


	@Test
	public void getStockListByuserIdで株式リスト取得_正常() throws Exception{
		String userId="hoge";
		List<Stock> stockList = stockService.getStockListByuserId(userId);
		
		for(int i=0; i<stockList.size();i++) {
			assertThat(stockList.get(i).getUserId()).isEqualTo("hoge");
			if(stockList.get(i).getStockId()==2) {
				assertThat(stockList.get(i).getStockCode()).isEqualTo("ABC");
			}
		}
	}


}
