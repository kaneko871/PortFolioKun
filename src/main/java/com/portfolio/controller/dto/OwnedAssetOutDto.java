package com.portfolio.controller.dto;

public class OwnedAssetOutDto {
	private String stockCode;
	private String stockName;
	private String stockNum;
	private String aveUnitPrice;
	private Double totalInvestment;

	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockNum() {
		return stockNum;
	}
	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}
	public String getAveUnitPrice() {
		return aveUnitPrice;
	}
	public void setAveUnitPrice(String aveUnitPrice) {
		this.aveUnitPrice = aveUnitPrice;
	}
	public Double getTotalInvestment() {
		return totalInvestment;
	}
	public void setTotalInvestment(Double stockNum, Double aveUnitPrice) {
		this.totalInvestment = stockNum + aveUnitPrice;
	}



}
