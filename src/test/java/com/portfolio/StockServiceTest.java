package com.portfolio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.portfolio.model.Stock;
import com.portfolio.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
class StockServiceTest {

	@Autowired
	private StockService stockService;

	@Test
	void findByIdでstockを取得() throws Exception {
		//stockService = new StockService();
		String stockId = "1";

		Stock actualStock=stockService.findById(stockId);

		assertEquals(actualStock.getStockId(), "1");
	}

	@Test
	void Junitのサンプルテスト実行用() throws Exception{
		//stockService = new StockService();

		String str="sample";
		boolean actualBool = stockService.sampleJunitTest(str);

		assertEquals(actualBool, true);
	}

	@Test
	void Junitのサンプルテスト実行用_false () throws Exception{
		//stockService = new StockService();

		String str="elpmas";
		boolean actualBool = stockService.sampleJunitTest(str);

		assertEquals(actualBool, false);
	}


}
