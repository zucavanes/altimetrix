package com.inventories.model;

import java.util.List;

public class InventoriesListModel {

	private String responseCode;
	private String responseMsg;
	private List<InventoriesModel> stockInfo;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public List<InventoriesModel> getStockInfo() {
		return stockInfo;
	}
	public void setStockInfo(List<InventoriesModel> stockInfo) {
		this.stockInfo = stockInfo;
	}
	
}
