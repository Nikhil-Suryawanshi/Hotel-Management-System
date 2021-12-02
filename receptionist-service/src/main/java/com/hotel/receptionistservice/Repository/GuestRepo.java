package com.hotel.receptionistservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.receptionistservice.models.Guest;

public interface GuestRepo extends MongoRepository<Guest, Integer> {

}
