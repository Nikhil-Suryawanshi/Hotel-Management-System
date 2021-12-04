package com.hotel.Staffservice.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="StaffDetails")
public class Staff {
	@Id
	private long empId;
	private String empName;
	private int empSalary;
	private String designation;
	private String email;
	
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(long empId, String empName, int empSalary, String designation, String email) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.designation = designation;
		this.email = email;
	}
	
	
}
