package com.hotel.managerservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.managerservice.Repository.StaffMongoRepo;
import com.hotel.managerservice.models.Staff;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffMongoRepo repo;

	@Override
	public Staff addEmp(Staff emp) {
		return repo.insert(emp);
	}

	@Override
	public Staff updateEmp(Staff emp) {
		return repo.save(emp);
	}

	@Override
	public String deleteEmp(long id) {
		repo.deleteById(id);
		return "Deleted employee with ID :"+id;
	}

	@Override
	public Optional<Staff> getEmp(long id) {
		return repo.findById(id);
	}
	
	
}
