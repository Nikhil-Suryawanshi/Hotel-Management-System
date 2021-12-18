package com.hotel.ownerservice.OwnerRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.ownerservice.models.OwnerInfo;



public interface OwnerRepo extends MongoRepository<OwnerInfo, String> {

	OwnerInfo findByEmail(String email);
		
	
	
}
