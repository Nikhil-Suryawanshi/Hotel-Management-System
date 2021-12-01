package com.hotel.managerservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.managerservice.Repository.InventoryMongoRepo;
import com.hotel.managerservice.models.Inventory;

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
