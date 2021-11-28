package com.portfolio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.portfolio.model.Stock;

public interface StockRepository extends JpaRepository<Stock, String>{

	@Query("select stock from Stock stock")
	public List<Stock> findAll();
	
	@Query("select stock"
			+ " from Stock stock"
			+ " where stock_id = :stockId")
	public Optional<Stock> findById(@Param("stockId") String stockId);
}
