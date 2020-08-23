package com.inventories.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventories.entities.InventoriesEntity;
import com.inventories.model.InventoriesListModel;
import com.inventories.model.InventoriesModel;
import com.inventories.model.InventoriesResponseModel;
import com.inventories.repository.InventoriesRepository;

@Service
public class InventoryService implements InventoryServiceI {

	@Autowired
	InventoriesRepository inventoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public InventoriesListModel getAllInventories() {

		InventoriesListModel list = new InventoriesListModel();
		
		List<InventoriesEntity> inventoryRepoList = new ArrayList<InventoriesEntity>();
		List<InventoriesModel> inventoryModelList = new ArrayList<InventoriesModel>();
		
		inventoryRepoList = inventoryRepository.findAll();
		inventoryModelList = convert(inventoryRepoList, inventoryModelList);
		list.setStockInfo(inventoryModelList);
		list.setResponseCode(HttpStatus.OK.toString());
		list.setResponseMsg(HttpStatus.OK.getReasonPhrase());
		return list;
		
	}

	@Override
	public InventoriesResponseModel updateInventories(InventoriesModel inventoriesModel) {

		InventoriesResponseModel respModel = new InventoriesResponseModel();
		boolean inventoryOp = findIfexists(inventoriesModel);
		if(inventoryOp)
		{
			try
			{
				InventoriesEntity invenEntity = new InventoriesEntity();
				invenEntity = convert(inventoriesModel, invenEntity);
				
				inventoryRepository.save(invenEntity);
				respModel.setResponseCode(HttpStatus.ACCEPTED.toString());
				respModel.setResponseMsg(HttpStatus.ACCEPTED.getReasonPhrase());
			}
			catch(Exception e)
			{
				respModel.setResponseCode(HttpStatus.BAD_REQUEST.toString());
				respModel.setResponseMsg(e.getMessage());
			}
		}
		else
		{
			respModel.setResponseCode(HttpStatus.NOT_FOUND.toString());
			respModel.setResponseMsg(HttpStatus.NOT_FOUND.getReasonPhrase());
		}
		return respModel;	
	}

	@Override
	public InventoriesResponseModel addInventories(InventoriesModel inventoriesModel) {
		InventoriesResponseModel respModel = new InventoriesResponseModel();

		boolean inventoryOp = findIfexists(inventoriesModel);
		if(!inventoryOp)
		{
			InventoriesEntity invenEntity = new InventoriesEntity();
			invenEntity = convert(inventoriesModel, invenEntity);
			
			//System.out.println(inventoriesModel.getStockName());
	
			try
			{
				inventoryRepository.save(invenEntity);
				respModel.setResponseCode(HttpStatus.CREATED.toString());
				respModel.setResponseMsg(HttpStatus.CREATED.getReasonPhrase());
			}
			catch(Exception e)
			{
				respModel.setResponseCode(HttpStatus.BAD_REQUEST.toString());
				respModel.setResponseMsg(e.getMessage());
			}
		}
		else
		{
			respModel.setResponseCode(HttpStatus.CONFLICT.toString());
			respModel.setResponseMsg("Stock ID Already Exists");
		}
		
		return respModel;
	}
	
	public boolean findIfexists(InventoriesModel inventoriesModel) {
 		boolean inventoryOp = inventoryRepository.existsById(inventoriesModel.getStockNumber());
		return inventoryOp;
	}
	
	
	@SuppressWarnings("unchecked")
	public <F,T>T convert(F from, T to)
	{
		to = (T) modelMapper.map(from,to.getClass());
		return to;
	}
}