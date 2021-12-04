package com.hotel.Guestservice.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.Guestservice.Models.Guest;

public interface GuestRepo extends MongoRepository<Guest, Integer> {

}
