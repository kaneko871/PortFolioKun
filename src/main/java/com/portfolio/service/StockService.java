package com.portfolio.service;

import java.util.List;

import com.portfolio.model.Stock;

public interface StockService {
	public List<Stock> findAll();
	public Stock findById(Integer stockId);
	public void insertStock(Stock stock,String userId);
	public List<Stock> getStockListByuserId(String userId);
}
