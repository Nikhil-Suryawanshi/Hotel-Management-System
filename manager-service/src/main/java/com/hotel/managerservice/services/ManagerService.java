package com.hotel.managerservice.services;

import java.util.List;
import java.util.Optional;

import com.hotel.managerservice.models.Room;

public interface ManagerService {

	Room addRoom(Room room);

	Optional<Room> getRoom(int id);

	Room updateRoom(Room room);

	String deleteRoom(int parseInt);

	List<Room> getAvailableRooms();

	List<Room> getAllRooms();
	
}
