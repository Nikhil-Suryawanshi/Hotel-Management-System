package com.hotel.managerservice.services;


import java.util.Optional;

import com.hotel.managerservice.models.Staff;

public interface StaffService {

	Staff addEmp(Staff emp);

	Staff updateEmp(Staff emp);

	String deleteEmp(long id);

	Optional<Staff> getEmp(long id);

}
