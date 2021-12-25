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

	@Override
	public List<Stock> findAll(){
		List<Stock> stockList = stockMapper.findAll();
		return stockList;
	}

	@Override
	public Stock findById(String stockId) {
		return stockMapper.findById(stockId);
	}

	@Override
	public void insertStock(Stock stock) {
		int maxStockId = stockMapper.selectMaxStockId();
		System.out.println("maxStockId: "+ maxStockId);
		stock.setStockId(String.valueOf(maxStockId+1));
		stockMapper.insertStock(stock);
	}


}
