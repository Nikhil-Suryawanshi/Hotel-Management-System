package com.hotel.managerservice.services;

import java.util.Optional;

import com.hotel.managerservice.models.Inventory;

public interface InventoryService {

	Inventory addInventory(Inventory inv);

	Inventory updateInventory(Inventory inv);

	String deleteInventory(int id);

	Optional<Inventory> getInventory(int id);
	
	
	
}
