package com.hotel.receptionistservice.controller;

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

import com.hotel.receptionistservice.models.Reservation;
import com.hotel.receptionistservice.models.ReservationList;

@RestController
@RequestMapping("/Reception/Reservation")
public class ReservationController {
	@Autowired
	private RestTemplate restTmp;
	
	@PostMapping("/makeReservation")
	public String makeReservation(@RequestBody Reservation res)
	{
		return restTmp.postForObject("http://localhost:8084/Reservation/bookRoom", res, String.class);
	}
	
	@GetMapping("/getReservations")
	public ReservationList getRes()
	{
		return restTmp.getForObject("http://localhost:8084/Reservation/getReservations", ReservationList.class);
	}
	
	@PutMapping("/updateReservation")
	public Reservation updateReservation(@RequestBody Reservation res)
	{
		restTmp.put("http://localhost:8084/Reservation/updateReservation", res);
		return res;
	}
	
	@DeleteMapping("/CancelReservation/{id}")
	public String cancelReservation(@PathVariable("id") String id)
	{
		restTmp.delete("http://localhost:8084/Reservation/deleteReservation/"+id);
		return "Canceled Reservation with Id: "+id;
	}
}
