package com.hotel.ownerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Owner")
public class OwnerController {
	
	@GetMapping("/hello")
	public String helloMsg() {
		return "hello owner";
	}
}
