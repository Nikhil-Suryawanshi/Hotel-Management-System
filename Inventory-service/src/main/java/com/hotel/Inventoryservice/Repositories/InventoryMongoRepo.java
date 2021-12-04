package com.hotel.Inventoryservice.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.Inventoryservice.Models.Inventory;


@Repository
public interface InventoryMongoRepo extends MongoRepository<Inventory, Integer> {

}
