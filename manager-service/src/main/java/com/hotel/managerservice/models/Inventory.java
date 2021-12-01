package com.hotel.managerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InventoryDetails")
public class Inventory {
	@Id
	private int inventoryId;
	private String invType;
	private String invName;
	private int invStock;
	
	
	
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getInvName() {
		return invName;
	}
	public void setInvName(String invName) {
		this.invName = invName;
	}
	public int getInvStock() {
		return invStock;
	}
	public void setInvStock(int invStock) {
		this.invStock = invStock;
	}
	public String getInvType() {
		return invType;
	}
	public void setInvType(String invType) {
		this.invType = invType;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(int inventoryId, String invName, int invStock, String invType) {
		super();
		this.inventoryId = inventoryId;
		this.invName = invName;
		this.invStock = invStock;
		this.invType = invType;
	}
	
	
}
