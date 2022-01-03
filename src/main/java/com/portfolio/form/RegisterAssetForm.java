package com.portfolio.form;

import lombok.Data;

@Data
public class RegisterAssetForm {
	private String companyId;
	private String stockId;
	private String kouzaKubun;
	private String stockNum;
	private String aveUnitPrice;
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
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
