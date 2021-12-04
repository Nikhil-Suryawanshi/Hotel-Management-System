package com.hotel.managerservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.managerservice.models.Inventory;
import com.hotel.managerservice.services.InventoryService;

@RestController
@RequestMapping("/Manager/Inventory")
public class InventoryController {
	@Autowired
	private InventoryService service;
	
	@PostMapping("/addInventory")
	public Inventory addInventory(@RequestBody Inventory inv)
	{
		return this.service.addInventory(inv);
	}
	
	@PutMapping("/updateInventory")
	public Inventory updateInventory(@RequestBody Inventory inv)
	{
		return this.service.updateInventory(inv);
	}
	
	@DeleteMapping("/deleteInventory/{id}")
	public String deleteInventory(@PathVariable("id") String id)
	{
		return this.service.deleteInventory(Integer.parseInt(id));
	}
	
	@GetMapping("/getInventory/{id}")
	public Optional<Inventory> getInventory(@PathVariable("id") String id)
	{
		return this.service.getInventory(Integer.parseInt(id));
	}
}
