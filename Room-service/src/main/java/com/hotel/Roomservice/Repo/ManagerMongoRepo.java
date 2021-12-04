package com.hotel.Roomservice.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.Roomservice.Models.Room;


@Repository
public interface ManagerMongoRepo extends MongoRepository<Room, Integer> {
	@Query("{isAvailable:true}")
	List<Room> findAvailable();
}
