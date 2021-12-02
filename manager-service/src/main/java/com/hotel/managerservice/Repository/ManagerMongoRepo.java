package com.hotel.managerservice.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.managerservice.models.Room;

@Repository
public interface ManagerMongoRepo extends MongoRepository<Room, Integer> {
	@Query("{isAvailable:true}")
	List<Room> findAvailable();
}
