package com.hotel.Inventoryservice.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Inventoryservice.Models.Inventory;
import com.hotel.Inventoryservice.Repositories.InventoryMongoRepo;


@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryMongoRepo repo;

	@Override
	public Inventory addInventory(Inventory inv) {
		return repo.insert(inv);
	}

	@Override
	public Inventory updateInventory(Inventory inv) {
		return repo.save(inv);
	}

	@Override
	public String deleteInventory(int id) {
		repo.deleteById(id);
		return "Deleted Inventory Id:"+id;
	}

	@Override
	public Optional<Inventory> getInventory(int id) {
		return repo.findById(id);
	}
	
	
}
