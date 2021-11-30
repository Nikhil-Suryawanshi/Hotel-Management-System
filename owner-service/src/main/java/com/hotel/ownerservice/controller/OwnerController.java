package com.hotel.ownerservice.controller;

import java.util.List;
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

import com.hotel.ownerservice.models.Department;
import com.hotel.ownerservice.services.OwnerService;

@RestController
@RequestMapping("/Owner")
public class OwnerController {
	@Autowired
	private OwnerService service;
	
	@GetMapping("/hello")
	public String helloMsg() {
		return "hello owner";
	}
	
	@PostMapping("/add")
	public Department addDept(@RequestBody Department dept) 
	{
		return this.service.addDepartment(dept); 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") String id) 
	{
		return this.service.deleteDepartment(Long.parseLong(id));
	}
	
	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department dept)
	{
		return this.service.updateDepartment(dept);
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Department> getDepartment(@PathVariable("id") String id)
	{
		return this.service.getDepartment(Long.parseLong(id));
	}
	
	@GetMapping("/ShowAll")
	public List<Department> getAllDepartments()
	{
		return this.service.getAllDepartments();
	}
	
}
