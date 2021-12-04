package com.hotel.Inventoryservice.Services;

import java.util.Optional;

import com.hotel.Inventoryservice.Models.Inventory;


public interface InventoryService {

	Inventory addInventory(Inventory inv);

	Inventory updateInventory(Inventory inv);

	String deleteInventory(int id);

	Optional<Inventory> getInventory(int id);
	
	
	
}
