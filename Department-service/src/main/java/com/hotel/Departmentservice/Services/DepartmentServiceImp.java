package com.hotel.Departmentservice.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Departmentservice.Models.Department;
import com.hotel.Departmentservice.Repo.MongoDBRepo;

@Service
public class DepartmentServiceImp implements DepartmentService {

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
