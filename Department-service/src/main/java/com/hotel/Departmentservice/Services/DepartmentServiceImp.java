package com.hotel.Departmentservice.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Departmentservice.Exception.RequestNotFoundException;
import com.hotel.Departmentservice.Models.Department;
import com.hotel.Departmentservice.Models.DepartmentList;
import com.hotel.Departmentservice.Repo.MongoDBRepo;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	private MongoDBRepo repo;
	
	public DepartmentServiceImp(MongoDBRepo repo) {
		this.repo=repo;
	}
	
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
		//boolean isDeptAvl=repo.existsById(dept.getDepartmentID());
			return repo.save(dept);
	}

	@Override
	public Optional<Department> getDepartment(long id) {
		return repo.findById(id);
	}

	@Override
	public DepartmentList getAllDepartments() {
		DepartmentList list =new DepartmentList();
		list.setDeptList(repo.findAll());
		return list;
	}

}
