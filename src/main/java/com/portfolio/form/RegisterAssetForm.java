package com.portfolio.form;

import lombok.Data;

@Data
public class RegisterAssetForm {
	private String companyName;
	private String stockCode;
	private String kouzaKubun;
	private String stockNum;
	private String aveUnitPrice;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
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
	
	
}
