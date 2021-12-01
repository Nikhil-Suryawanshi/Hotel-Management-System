package com.hotel.managerservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.managerservice.models.Inventory;

@Repository
public interface InventoryMongoRepo extends MongoRepository<Inventory, Integer> {

}
