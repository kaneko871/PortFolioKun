package com.portfolio.model;

import lombok.Data;

@Data
public class Asset {
	private String userId;
	private String companyId;
	private String kouzaKubun;
	private Integer stockId;
	private String stockNum;
	private String aveUnitPrice;


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getKouzaKubun() {
		return kouzaKubun;
	}
	public void setKouzaKubun(String kouzaKubun) {
		this.kouzaKubun = kouzaKubun;
	}
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
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



}
