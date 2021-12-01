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

import com.hotel.ownerservice.models.Room;

@RestController
@RequestMapping("/Owner/Manager")
public class OwnerRoomController {
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/getRoom/{id}")
	public Room getRoom(@PathVariable("id") String id) 
	{
		return restTemplate.getForObject("http://localhost:8082/Manager/getRoom/"+id, Room.class);
	}
	
	@PostMapping("/addRoom")
	public Room addRoom(@RequestBody Room room) 
	{
		return restTemplate.postForObject("http://localhost:8082/Manager/addRoom", room, Room.class);
	}
	
	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room room)
	{
		restTemplate.put("http://localhost:8082/Manager/updateRoom", room);
		return room;
	}
	
	@DeleteMapping("deleteRoom/{id}")
	public String deleteRoom(@PathVariable("id") String id)
	{
		restTemplate.delete("http://localhost:8082/Manager/deleteRoom/"+id);
		return "Deleted room "+id;
	}
}
