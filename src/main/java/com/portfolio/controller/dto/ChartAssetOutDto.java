package com.portfolio.controller.dto;

public class ChartAssetOutDto {
	private String stockCode;
	private Double totalInvestment;
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public Double getTotalInvestment() {
		return totalInvestment;
	}
	public void setTotalInvestment(Double stockNum, Double aveUnitPrice) {
		this.totalInvestment = stockNum * aveUnitPrice;
	}



}
