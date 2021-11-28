package com.portfolio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.portfolio.model.Stock;
import com.portfolio.repository.StockRepository;
import com.portfolio.service.StockService;

@Service
@Primary
public class StockServiceImpl2 implements StockService{
	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> findAll(){
		List<Stock> stockList = stockRepository.findAll();
		return stockList;
	}

	@Override
	public Stock findById(String stockId) {
		Optional<Stock> option = stockRepository.findById(stockId);
		Stock stock= option.orElse(null);
		return stock;
	}


}
