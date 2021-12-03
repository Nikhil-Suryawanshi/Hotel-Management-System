package com.hotel.receptionistservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ReservationDetails")
public class Reservation {
	@Id
	private int id;
	private int guestId;
	private int roomId;
	private String checkInDate;
	private String checkOutDate;
	private String status;
	private String noOfGuest;
	private int noOfNight;
	/*
		private int noOfAdults;
		private int noOfChildren;
	 * 
	 * */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNoOfGuest() {
		return noOfGuest;
	}
	public void setNoOfGuest(String noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	public int getNoOfNight() {
		return noOfNight;
	}
	public void setNoOfNight(int noOfNight) {
		this.noOfNight = noOfNight;
	}
	
	
	
}
