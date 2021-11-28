package com.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.model.Stock;
import com.portfolio.repository.StockMapper;
import com.portfolio.service.StockService;

/*利用していないクラス。JPAからMybatisに切り替えときのために残す。*/
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


}
