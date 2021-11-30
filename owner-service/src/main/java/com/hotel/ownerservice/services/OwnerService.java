package com.hotel.ownerservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.ownerservice.models.Department;

@Service
public interface OwnerService {
	public Department addDepartment(Department dept);

	public String deleteDepartment(long id);

	public Department updateDepartment(Department dept);

	public Optional<Department> getDepartment(long id);

	public List<Department> getAllDepartments();
}
