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

	public Stock findById(String stockId) {
		return stockMapper.findById(stockId);
	}

	public boolean sampleJunitTest(String str) {
		boolean isBool=false;

		if(str.equals(("sample"))) {
			isBool=true;
		}else {
			isBool=false;
		}
		return isBool;
	}

}
