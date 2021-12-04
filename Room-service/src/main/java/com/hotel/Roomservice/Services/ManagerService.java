package com.hotel.Roomservice.Services;

import java.util.List;
import java.util.Optional;

import com.hotel.Roomservice.Models.Room;


public interface ManagerService {

	Room addRoom(Room room);

	Optional<Room> getRoom(int id);

	Room updateRoom(Room room);

	String deleteRoom(int parseInt);

	List<Room> getAvailableRooms();

	List<Room> getAllRooms();
	
}
