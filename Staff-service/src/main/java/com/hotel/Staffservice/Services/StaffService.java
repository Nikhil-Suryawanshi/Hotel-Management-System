package com.hotel.Staffservice.Services;


import java.util.Optional;

import com.hotel.Staffservice.Models.Staff;


public interface StaffService {

	Staff addEmp(Staff emp);

	Staff updateEmp(Staff emp);

	String deleteEmp(long id);

	Optional<Staff> getEmp(long id);

}
