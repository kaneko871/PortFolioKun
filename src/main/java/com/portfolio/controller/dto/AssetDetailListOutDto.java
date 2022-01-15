package com.portfolio.controller.dto;

public class AssetDetailListOutDto {
	private String companyName;
	private String kouzaKubun;
	private String stockNum;
	private String aveUnitPrice;
	private Double totalInvestment;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getKouzaKubun() {
		return kouzaKubun;
	}
	public void setKouzaKubun(String kouzaKubun) {
		this.kouzaKubun = kouzaKubun;
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
	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}


}
