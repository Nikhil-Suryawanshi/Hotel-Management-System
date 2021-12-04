package com.hotel.Guestservice.Services;

import java.util.List;
import java.util.Optional;

import com.hotel.Guestservice.Models.Guest;


public interface GuestService {

	Guest addGuest(Guest guest);

	Guest updateGuest(Guest guest);

	String deleteGuest(int id);

	Optional<Guest> getGuest(int id);

	List<Guest> getAllGuest();

}
