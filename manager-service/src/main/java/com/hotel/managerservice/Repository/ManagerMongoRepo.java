package com.hotel.managerservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.managerservice.models.Room;

@Repository
public interface ManagerMongoRepo extends MongoRepository<Room, Integer> {

}
