package com.hotel.ownerservice.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.ownerservice.models.Department;

@Repository
public interface MongoDBRepo extends MongoRepository<Department, Long>{

}
