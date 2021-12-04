package com.hotel.Roomservice.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Roomservice.Models.Room;
import com.hotel.Roomservice.Repo.ManagerMongoRepo;


@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerMongoRepo repo;

	@Override
	public Room addRoom(Room room) {
		return repo.insert(room);
	}

	@Override
	public Optional<Room> getRoom(int id) {
		return repo.findById(id);
	}

	@Override
	public Room updateRoom(Room room) {
		return repo.save(room);
	}

	@Override
	public String deleteRoom(int parseInt) {
		repo.deleteById(parseInt);
		return "Room Number "+parseInt+" Deleted";
	}

	@Override
	public List<Room> getAvailableRooms() {
		return repo.findAvailable();
	}

	@Override
	public List<Room> getAllRooms() {
		return repo.findAll();
	}
	
	
}
