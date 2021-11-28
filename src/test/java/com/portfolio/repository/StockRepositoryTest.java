package com.portfolio.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.portfolio.model.Stock;

@DataJpaTest
@Sql(scripts="classpath:/stock.sql", 
		executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class StockRepositoryTest {
	@Autowired
	StockRepository stockRepository;
	
	@Test
	void findByIdのTest() {
		Stock stock = stockRepository.findById("hoge").get();
		assertThat(stock.getStockId()).isEqualTo("hoge");
	}
}
