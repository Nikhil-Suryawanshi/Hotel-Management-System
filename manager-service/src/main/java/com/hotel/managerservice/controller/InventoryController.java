package com.hotel.managerservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hotel.managerservice.models.Inventory;

@RestController
@RequestMapping("/Manager/Inventory")
public class InventoryController {
	
	@Autowired
	private RestTemplate restTmp;
	
	@PostMapping("/addInventory")
	public Inventory addInventory(@RequestBody Inventory inv)
	{
		return restTmp.postForObject("http://Inventory-microservice/Inventory/addInventory", inv, Inventory.class);
	}
	
	@PutMapping("/updateInventory")
	public Inventory updateInventory(@RequestBody Inventory inv)
	{
		restTmp.put("http://Inventory-microservice/Inventory/updateInventory", inv);
		return inv;
	}
	
	@DeleteMapping("/deleteInventory/{id}")
	public String deleteInventory(@PathVariable("id") String id)
	{
		restTmp.delete("http://Inventory-microservice/Inventory/deleteInventory/"+id);
		return "Deleted Inventory with Id: "+id;
	}
	
	@GetMapping("/getInventory/{id}")
	public Inventory getInventory(@PathVariable("id") String id)
	{
		return restTmp.getForObject("http://Inventory-microservice/Inventory/getInventory/"+id, Inventory.class);
	}
}
