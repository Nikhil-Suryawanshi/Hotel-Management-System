package com.hotel.receptionistservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Reception")
public class ReceptionController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello Receptionist";
	}
}
