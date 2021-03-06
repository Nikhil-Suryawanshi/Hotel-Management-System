package com.hotel.ownerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="OwnerInfo" )
public class OwnerInfo {
     
	@Id
	private String id;
	private String email;
	private String password;
	private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public OwnerInfo(String id, String email, String password ,String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role=role;
	}
	public OwnerInfo() {
	
	}
	
	
	
	
    
}