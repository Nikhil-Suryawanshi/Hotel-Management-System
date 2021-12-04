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

import com.hotel.managerservice.models.Room;
import com.hotel.managerservice.models.RoomList;


@RestController
@RequestMapping("/Manager/Room")
public class RoomController {
	
	@Autowired
	private RestTemplate restTmp;
	
	@PostMapping("/addRoom")
	public Room addRoom(@RequestBody Room room) {
		return restTmp.postForObject("http://Room-Microservice/Room/addRoom", room, Room.class);
	}
	
	@GetMapping("/getRoom/{id}")
	public Room getRoom(@PathVariable("id") String id)
	{
		return restTmp.getForObject("http://Room-Microservice/Room/getRoom/"+id, Room.class);
	}
	
	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room room)
	{
		restTmp.put("http://Room-Microservice/Room/updateRoom", room);
		return room;
	}
	
	@DeleteMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable("id") String id)
	{
		restTmp.delete("http://Room-Microservice/Room/deleteRoom/"+id);
		return "Deleted Room Id: "+id;
	}
	
	@GetMapping("/getAllRooms")
	public RoomList getAllRooms()
	{
		return restTmp.getForObject("http://Room-Microservice/Room/getAllRooms", RoomList.class);
	}
	
	@GetMapping("/getAvailableRooms")
	public RoomList getAvailableRooms()
	{
		return restTmp.getForObject("http://Room-Microservice/Room/getAvlRooms", RoomList.class);
	}
	
}
