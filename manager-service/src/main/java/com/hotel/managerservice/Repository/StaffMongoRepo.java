package com.hotel.managerservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.managerservice.models.Staff;

public interface StaffMongoRepo extends MongoRepository<Staff, Long> {

}
