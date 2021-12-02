package com.hotel.managerservice.controller;

import java.util.Optional;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.managerservice.models.Room;
import com.hotel.managerservice.models.RoomList;
import com.hotel.managerservice.services.ManagerService;


@RestController
@RequestMapping("/Manager")
public class ManagerController {
	
	@Autowired
	private ManagerService service;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello manager";
	}
	
	@PostMapping("/addRoom")
	public Room addRoom(@RequestBody Room room) {
		return this.service.addRoom(room);
	}
	
	@GetMapping("/getRoom/{id}")
	public Optional<Room> getRoom(@PathVariable("id") String id)
	{
		return this.service.getRoom(Integer.parseInt(id));
	}
	
	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room room)
	{
		return this.service.updateRoom(room);
	}
	
	@DeleteMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable("id") String id)
	{
		return this.service.deleteRoom(Integer.parseInt(id));
	}
	
	@GetMapping("/getAllRooms")
	public RoomList getAllGuest()
	{
		RoomList list=new RoomList();
		list.setAllRooms(this.service.getAllRooms());
		return list;
	}
	
	@GetMapping("/getAvlRooms")
	public RoomList getAvlRooms()
	{
		RoomList list=new RoomList();
		list.setAllRooms(this.service.getAvailableRooms());
		return list;
	}
	
}
