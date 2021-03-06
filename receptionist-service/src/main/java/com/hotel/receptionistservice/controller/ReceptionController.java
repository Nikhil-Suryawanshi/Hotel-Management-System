package com.hotel.receptionistservice.controller;

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
import org.springframework.web.client.RestTemplate;

import com.hotel.receptionistservice.models.Guest;
import com.hotel.receptionistservice.models.GuestList;

@RestController
@RequestMapping("/Reception/Guest")
public class ReceptionController {
	
	@Autowired
	private RestTemplate restTmp;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Receptionist";
	}
	
	@PostMapping("/addGuest")
	public Guest addGuest(@RequestBody Guest guest)
	{
		return restTmp.postForObject("http://Guest-microservice/Guest/addGuest", guest, Guest.class);
	}
	
	@PutMapping("/updateGuest")
	public Guest updateGuest(@RequestBody Guest guest)
	{
		restTmp.put("http://Guest-microservice/Guest/updateGuest", guest);
		return guest;
	}
	
	@DeleteMapping("/deleteGuest/{id}")
	public String deleteGuestById(@PathVariable("id") String id)
	{
		restTmp.delete("http://Guest-microservice/Guest/deleteGuest/"+id);
		return "Deleted Guest with id: "+id;
	}
	
	@GetMapping("getGuest/{id}")
	public Guest getGuest(@PathVariable String id)
	{
		return restTmp.getForObject("http://Guest-microservice/Guest/getGuest/"+id, Guest.class);
	}
	
	@GetMapping("getAllGuest")
	public GuestList getAllGuest()
	{
		return restTmp.getForObject("http://Guest-microservice/Guest/getAllGuest", GuestList.class);
	}
	
}
