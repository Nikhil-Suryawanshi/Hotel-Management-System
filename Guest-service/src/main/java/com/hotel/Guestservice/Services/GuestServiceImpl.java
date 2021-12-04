package com.hotel.Guestservice.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Guestservice.Models.Guest;
import com.hotel.Guestservice.Repo.GuestRepo;


@Service
public class GuestServiceImpl implements GuestService {
	@Autowired
	private GuestRepo repo;

	@Override
	public Guest addGuest(Guest guest) {
		return repo.insert(guest);
	}

	@Override
	public Guest updateGuest(Guest guest) {
		return repo.save(guest);
	}

	@Override
	public String deleteGuest(int id) {
		repo.deleteById(id);
		return "Deleted Guest Id: "+id;
	}

	@Override
	public Optional<Guest> getGuest(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Guest> getAllGuest() {
		return repo.findAll();
	}
	
}
