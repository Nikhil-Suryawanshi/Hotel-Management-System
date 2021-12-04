package com.hotel.receptionistservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hotel.receptionistservice.models.Room;
import com.hotel.receptionistservice.models.RoomList;

@RestController
@RequestMapping("Reception/Rooms")
public class RoomController {
	@Autowired
	private RestTemplate restTmp;
	
	@GetMapping("/getAvailableRooms")
	public RoomList getAvailableRooms()
	{
		return restTmp.getForObject("http://Room-Microservice/Room/getAvlRooms", RoomList.class);
	}
	
	@GetMapping("/getAllRooms")
	public RoomList getAllRooms()
	{
		return restTmp.getForObject("http://Room-Microservice/Room/getAllRooms", RoomList.class);
	}
	
	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room room)
	{
		restTmp.put("http://Room-Microservice/Room/updateRoom", room);
		return room;
	}
	
	@GetMapping("/getRoom/{id}")
	public Room getRoom(@PathVariable("id") String id)
	{
		return restTmp.getForObject("http://Room-Microservice/Room/getRoom/"+id, Room.class);
	}
}
