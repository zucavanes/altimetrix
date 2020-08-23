package com.inventories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventories.entities.InventoriesEntity;

public interface InventoriesRepository extends JpaRepository<InventoriesEntity, Integer> {
	List<InventoriesEntity> findAll();
}