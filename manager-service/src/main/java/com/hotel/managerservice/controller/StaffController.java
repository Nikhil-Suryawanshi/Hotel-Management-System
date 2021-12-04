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

import com.hotel.managerservice.models.StaffList;
import com.hotel.managerservice.models.Staff;

@RestController
@RequestMapping("/Manager/Staff")
public class StaffController {
	@Autowired
	private RestTemplate restTmp;
	
	@PostMapping("/addEmp")
	public Staff addEmployee(@RequestBody Staff emp)
	{
		return restTmp.postForObject("http://Staff-microservice/Staff/addEmp", emp, Staff.class);
	}
	
	@PutMapping("/updateEmp")
	public Staff updateEmployee(@RequestBody Staff emp)
	{
		restTmp.put("http://Staff-microservice/Staff/updateEmp", emp);
		return emp;
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable("id") String id)
	{
		restTmp.delete("http://Staff-microservice/Staff/deleteEmp/"+id);
		return "Deleted Staff id: "+id;
	}
	
	@GetMapping("/getEmp/{id}")
	public Staff getEmployee(@PathVariable("id") String id)
	{
		return restTmp.getForObject("http://Staff-microservice/Staff/getEmp/"+id, Staff.class);
	}
	
	@GetMapping("/getAllEmp")
	public StaffList getAllStaff() {
		return restTmp.getForObject("http://Staff-microservice/Staff/getAllEmp", StaffList.class);
	}
}
