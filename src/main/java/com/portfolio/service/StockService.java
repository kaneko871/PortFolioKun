package com.portfolio.service;

import java.util.List;

import com.portfolio.model.Stock;

public interface StockService {
	public List<Stock> findAll();
	public Stock findById(String stockId);


}
