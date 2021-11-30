package com.hotel.managerservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.managerservice.Repository.ManagerMongoRepo;
import com.hotel.managerservice.models.Room;

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
	
	
}
