package com.hotel.ownerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="RoomDetails")
public class Room {
	@Id
	private int roomNum;
	private String type;
	private double roomRent;
	private boolean isAvailable;
	private String desc;
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public double getRoomRent() {
		return roomRent;
	}
	public void setRoomRent(double roomRent) {
		this.roomRent = roomRent;
	}
	
	public Room() {
		super();
	}
	public Room(int roomNum, String type, double roomRent, boolean isAvailable, String desc) {
		super();
		this.roomNum = roomNum;
		this.type = type;
		this.roomRent = roomRent;
		this.isAvailable = isAvailable;
		this.desc = desc;
	}
	
	
}
