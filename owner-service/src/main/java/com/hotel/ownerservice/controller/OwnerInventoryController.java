package com.hotel.ownerservice.controller;

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
import com.hotel.ownerservice.models.Inventory;

@RestController
@RequestMapping("/Owner/Manager")
public class OwnerInventoryController {
	@Autowired
	private RestTemplate restTmp;
	
	@PostMapping("/addInventory")
	public Inventory addInventory(@RequestBody Inventory inv)
	{
		return restTmp.postForObject("http://localhost:8082/Manager/addInventory", inv, Inventory.class);
	}
	
	@PutMapping("/updateInventory")
	public Inventory updateInventory(@RequestBody Inventory inv)
	{
		restTmp.put("http://localhost:8082/Manager/updateInventory", inv);
		return inv;
	}
	
	@DeleteMapping("/deleteInventory/{id}")
	public String deleteInventory(@PathVariable("id") String id)
	{
		restTmp.delete("http://localhost:8082/Manager/deleteInventory/"+id);
		return "Deleted Inventory ID:"+id;
	}
	
	@GetMapping("/getInventory/{id}")
	public Inventory getInventory(@PathVariable("id") String id)
	{
		return restTmp.getForObject("http://localhost:8082/Manager/getInventory/"+id, Inventory.class);
	}
}
