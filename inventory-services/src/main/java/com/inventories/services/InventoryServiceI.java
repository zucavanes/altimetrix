package com.inventories.services;

import org.springframework.stereotype.Service;

import com.inventories.model.InventoriesListModel;
import com.inventories.model.InventoriesModel;
import com.inventories.model.InventoriesResponseModel;

@Service
public interface InventoryServiceI {

	InventoriesListModel getAllInventories();
	InventoriesResponseModel updateInventories(InventoriesModel inventoriesModel);
	InventoriesResponseModel addInventories(InventoriesModel inventoriesModel);
}