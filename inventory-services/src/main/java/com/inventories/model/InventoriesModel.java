package com.inventories.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

@SuppressWarnings("unused")
public class InventoriesModel {

	private int stockNumber; 
	private String stockName;
	private Double purchasingPrice;
	private Date purchaseDate;
	private int quantity;
	
	public int getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
}