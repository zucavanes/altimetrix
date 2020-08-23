package com.inventories.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "stocks")

public class InventoriesEntity {
	
	@Id
	@Getter @Setter private int stockNumber; 
	@Getter @Setter private String stockName;
	@Getter @Setter private Double purchasingPrice;
	@Getter @Setter private Date purchaseDate;
	@Getter @Setter private int quantity;	
}
