package com.hotel.managerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Manager")
public class ManagerController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello manager";
	}
}
