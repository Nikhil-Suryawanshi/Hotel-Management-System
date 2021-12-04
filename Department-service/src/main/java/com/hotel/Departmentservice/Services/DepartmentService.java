package com.hotel.Departmentservice.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.Departmentservice.Models.Department;
import com.hotel.Departmentservice.Models.DepartmentList;

@Service
public interface DepartmentService {
	public Department addDepartment(Department dept);

	public String deleteDepartment(long id);

	public Department updateDepartment(Department dept);

	public Optional<Department> getDepartment(long id);

	public DepartmentList getAllDepartments();
}
