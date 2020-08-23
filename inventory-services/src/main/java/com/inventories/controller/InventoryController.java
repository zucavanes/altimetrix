package com.inventories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventories.model.InventoriesListModel;
import com.inventories.model.InventoriesModel;
import com.inventories.model.InventoriesResponseModel;
import com.inventories.services.InventoryService;

@RestController
@RequestMapping("/stock")
public class InventoryController {
	
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/display")
	public InventoriesListModel getAllInventories()
	{
		InventoriesListModel list = new InventoriesListModel();
		list = inventoryService.getAllInventories();
		return list;
	}
	
	@PostMapping("/create")
	public InventoriesResponseModel createInventory(@RequestBody InventoriesModel inventoriesModel)
	{
		return inventoryService.addInventories(inventoriesModel);
	}
	
	@PutMapping("/update")
	public InventoriesResponseModel updateInventory(@RequestBody InventoriesModel inventoriesModel)
	{
		return inventoryService.updateInventories(inventoriesModel);
	} 
	
}
