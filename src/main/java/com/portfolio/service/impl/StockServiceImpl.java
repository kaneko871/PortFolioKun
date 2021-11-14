package com.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.StockMapper;
import com.portfolio.model.Stock;
import com.portfolio.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	@Autowired
	StockMapper stockMapper;

	public List<Stock> findAll(){
		List<Stock> stockList = stockMapper.findAll();
		return stockList;
	}

	public Stock findById(String stockId) {
		return stockMapper.findById(stockId);
	}


}
