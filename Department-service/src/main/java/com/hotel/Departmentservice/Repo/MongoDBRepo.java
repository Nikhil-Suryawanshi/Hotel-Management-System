package com.hotel.Departmentservice.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.Departmentservice.Models.Department;

@Repository
public interface MongoDBRepo extends MongoRepository<Department, Long>{

}
