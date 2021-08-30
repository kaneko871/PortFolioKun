package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mapper.StockMapper;
import com.portfolio.model.Stock;

@Service
public class StockService {
	@Autowired
	StockMapper stockMapper;

	public List<Stock> findAll(){
		List<Stock> stockList = stockMapper.findAll();
		return stockList;
	}

}
