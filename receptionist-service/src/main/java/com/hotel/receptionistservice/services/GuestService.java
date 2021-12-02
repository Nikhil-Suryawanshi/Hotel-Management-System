package com.hotel.receptionistservice.services;

import java.util.List;
import java.util.Optional;

import com.hotel.receptionistservice.models.Guest;
import com.hotel.receptionistservice.models.GuestList;

public interface GuestService {

	Guest addGuest(Guest guest);

	Guest updateGuest(Guest guest);

	String deleteGuest(int id);

	Optional<Guest> getGuest(int id);

	List<Guest> getAllGuest();

}
