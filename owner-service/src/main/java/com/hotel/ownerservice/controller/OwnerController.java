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

import com.hotel.ownerservice.models.Department;
import com.hotel.ownerservice.models.DepartmentList;

@RestController
@RequestMapping("/Owner/Department")
public class OwnerController {
	@Autowired
	private RestTemplate restTmp;
	
	@GetMapping("/hello")
	public String helloMsg() {
		return "hello owner";
	}
	
	@PostMapping("/add")
	public Department addDept(@RequestBody Department dept) 
	{
		return restTmp.postForObject("http://Department-microservice/Department/add", dept, Department.class);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") String id) 
	{
		restTmp.delete("http://Department-microservice/Department/delete/"+id);
		return "Deleted Department Id: "+id;
	}
	
	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department dept)
	{
		restTmp.put("http://Department-microservice/Department/update", dept);
		return dept;
	}
	
	@GetMapping("/findById/{id}")
	public Department getDepartment(@PathVariable("id") String id)
	{
		return restTmp.getForObject("http://Department-microservice/Department/findById/"+id, Department.class);
	}
	
	@GetMapping("/ShowAll")
	public DepartmentList getAllDepartments()
	{
		return restTmp.getForObject("http://Department-microservice/Department/ShowAll", DepartmentList.class);
	}
	
	
}
