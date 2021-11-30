package com.hotel.ownerservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.ownerservice.models.Department;

@Service
public class OwnerServiceImp implements OwnerService {

	@Autowired
	private MongoDBRepo repo;
	
	@Override
	public Department addDepartment(Department dept) {
		return repo.insert(dept);
	}

	@Override
	public String deleteDepartment(long id) {
		repo.deleteById(id);
		return "Department Deleted";
	}

	@Override
	public Department updateDepartment(Department dept) {
		return repo.save(dept);
	}

	@Override
	public Optional<Department> getDepartment(long id) {
		return repo.findById(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		return repo.findAll();
	}

}
