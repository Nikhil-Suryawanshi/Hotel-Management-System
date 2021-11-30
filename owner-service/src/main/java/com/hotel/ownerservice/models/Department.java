package com.hotel.ownerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Department {
	@Id
	private long departmentID;
	private String departmentName;
	private String desc;
	private int noOfEmp;
	public long getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getNoOfEmp() {
		return noOfEmp;
	}
	public void setNoOfEmp(int noOfEmp) {
		this.noOfEmp = noOfEmp;
	}
	public Department(long departmentID, String departmentName, String desc, int noOfEmp) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.desc = desc;
		this.noOfEmp = noOfEmp;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
