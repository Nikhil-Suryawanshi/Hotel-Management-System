package com.hotel.Staffservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.Staffservice.Models.Staff;


public interface StaffMongoRepo extends MongoRepository<Staff, Long> {

}
